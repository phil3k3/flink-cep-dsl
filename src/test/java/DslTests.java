import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternSelectFunction;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.cep.pattern.conditions.IterativeCondition;
import org.apache.flink.cep.pattern.conditions.SimpleCondition;
import org.apache.flink.shaded.curator.org.apache.curator.shaded.com.google.common.collect.Lists;
import org.apache.flink.streaming.api.TimeCharacteristic;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.AssignerWithPunctuatedWatermarks;
import org.apache.flink.streaming.api.watermark.Watermark;
import org.junit.Before;
import org.junit.Test;

import at.datasciencelabs.pattern.Dsl;
import at.datasciencelabs.pattern.Event;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DslTests {

    private static final int WATERMARK_OFFSET = 5;
    private static Map<String, List<Event>> results = new HashMap<>();

    @Before
    public void onBefore() {
        results.clear();
    }

    @Test
    public void shouldEvaluateNextPattern() throws Exception {
        TestEvent event = new TestEvent();
        event.setEventType("A");
        event.setAttribute("attribute", "testabc");
        TestEvent event2 = new TestEvent();
        event2.setEventType("B");
        event2.setAttribute("attribute", 30);
        executeTest("A(attribute='testabc') B(attribute=30)", Lists.newArrayList(event, event2));

        assertThat(results.size(), is(2));
    }

    @Test
    public void shouldEvaluateNextPatternAndFail() throws Exception {
        TestEvent event = new TestEvent();
        event.setAttribute("attribute", "testabc");
        TestEvent event2 = new TestEvent();
        event2.setAttribute("attribute", "testabc2");
        TestEvent event3 = new TestEvent();
        event3.setAttribute("attribute", 30);
        executeTest("A(attribute='testabc') B(attribute=30)", Lists.newArrayList(event, event2, event3));

        assertThat(results.size(), is(0));
    }

    @Test
    public void shouldEvaluateFollowedByPattern() throws Exception {
        TestEvent event = new TestEvent();
        event.setAttribute("attribute", "testabc");
        event.setEventType("A");
        TestEvent event2 = new TestEvent();
        event2.setEventType("B");
        event2.setAttribute("attribute", "testabc2");
        TestEvent event3 = new TestEvent();
        event3.setEventType("B");
        event3.setAttribute("attribute", 30);
        executeTest("A(attribute='testabc') -> B(attribute=30)", Lists.newArrayList(event, event2, event3));

        assertThat(results.size(), is(2));
    }

    @Test
    public void shouldEvaluateTimes4() throws Exception {
        List<Event> events = generate(4);

        executeTest("A{4}(attribute='testabc')", events);

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(4));
    }

    @Test
    public void shouldEvaluateTimes4OrZero() throws Exception {
        List<Event> events = generate(4);

        executeTest("A{4}(attribute='testabc')?", events);

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(4));
    }

    @Test
    public void shouldEvaluateThreeForTwoThreeOrFour() throws Exception {
        List<Event> events = generate(3);

        executeTest("A{2,4}(attribute='testabc')", events);

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        // all results are 2 because it is not greedy
        assertThat(results.get("A").size(), is(2));
    }

    @Test
    public void shouldEvaluateTwoForTwoThreeOrFour() throws Exception {
        List<Event> events = generate(2);

        executeTest("A{2,4}(attribute='testabc')", events);

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        // all results are 2 because it is not greedy
        assertThat(results.get("A").size(), is(2));
    }

    @Test
    public void shouldEvaluateFourForTwoThreeOrFour() throws Exception {
        List<Event> events = generate(4);

        executeTest("A{2,4}(attribute='testabc')", events);

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        // all results are 2 because it is not greedy
        assertThat(results.get("A").size(), is(2));
    }

    @Test
    public void shouldEvaluateFourForTwoThreeOrFourGreedy() throws Exception {
        List<Event> events = generate(4);

        executeTest("A{2,4}?(attribute='testabc')", events);

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(4));
    }

    @Test
    public void shouldEvaluateZeroOrMoreOne() throws Exception {
        List<Event> events = generate(1);

        executeTest("A*(attribute='testabc')", events);

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(1));
    }

    @Test
    public void shouldEvaluteZeroOrMoreTwoTestEvents() throws Exception {
        TestEvent event = new TestEvent();
        event.setAttribute("attribute", "testabc");
        event.setEventType("A");
        TestEvent event2 = new TestEvent();
        event2.setAttribute("attribute", 30);
        event2.setEventType("B");

        executeTest("A*(attribute='testabc') B(attribute=30)", Lists.newArrayList(event, event2));

        assertThat(results.size(), is(2));
        assertThat(results.containsKey("B"), is(true));
        assertThat(results.get("B").size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(1));
    }

    @Test
    public void shouldEvaluteZeroOrMoreOneTestEvent() throws Exception {
        TestEvent event2 = new TestEvent();
        event2.setAttribute("attribute", 30);
        event2.setEventType("B");

        executeTest("A*(attribute='testabc') B(attribute=30)", Lists.newArrayList(event2));

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("B"), is(true));
        assertThat(results.get("B").size(), is(1));
        assertThat(results.containsKey("A"), is(false));
    }

    @Test
    public void shouldEvaluteOneOptionalOneTestEvent() throws Exception {
        TestEvent event2 = new TestEvent();
        event2.setAttribute("attribute", 30);
        event2.setEventType("B");

        executeTest("A{1}(attribute='testabc')? B(attribute=30)", Lists.newArrayList(event2));

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("B"), is(true));
        assertThat(results.get("B").size(), is(1));
        assertThat(results.containsKey("A"), is(false));
    }

    @Test
    public void shouldEvaluteTwoOptionalOneTestEvent() throws Exception {
        TestEvent event2 = new TestEvent();
        event2.setAttribute("attribute", 30);
        event2.setEventType("B");

        executeTest("A{2}(attribute='testabc')? B(attribute=30)", Lists.newArrayList(event2));

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("B"), is(true));
        assertThat(results.get("B").size(), is(1));
        assertThat(results.containsKey("A"), is(false));
    }

    @Test
    public void shouldEvaluateZeroOrMoreTwo() throws Exception {
        List<Event> events = generate(2);

        executeTest("A*(attribute='testabc')", events);

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        // all results are 2 because it is not greedy
        assertThat(results.get("A").size(), is(1));
    }

    @Test
    public void shouldEvaluateTimesOrMoreThree() throws Exception {
        List<Event> events = generate(3);

        executeTest("A{2,+}(attribute='testabc')", events);

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        // all results are 2 because it is not greedy
        assertThat(results.get("A").size(), is(2));
    }

    @Test
    public void shouldEvaluateTimesOrMoreThreeGreedy() throws Exception {
        List<Event> events = generate(3);

        executeTest("A{2,+}?(attribute='testabc')", events);

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(3));
    }

    @Test
    public void shouldEvaluateTimesOrMoreThreeGreedyOptional() throws Exception {
        TestEvent event2 = new TestEvent();
        event2.setAttribute("attribute", 30);
        event2.setEventType("B");

        executeTest("A{2,+}?(attribute='testabc')? B(attribute=30)", Lists.newArrayList(event2));

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(false));
        assertThat(results.containsKey("B"), is(true));
        assertThat(results.get("B").size(), is(1));
    }

    @Test
    public void shouldEvaluateFollowedByAny() throws Exception {
        TestEvent event = new TestEvent();
        event.setEventType("A");
        event.setAttribute("attribute", "testabc");
        TestEvent event2 = new TestEvent();
        event2.setEventType("C");
        event2.setAttribute("attribute", "testabc2");
        TestEvent event3 = new TestEvent();
        event3.setEventType("B");
        event3.setAttribute("attribute", 30);

        executeTest("A(attribute='testabc') ->> B(attribute=30)", Lists.newArrayList(event, event2, event3));
    }

    @Test
    public void shouldEvaluateCorrelation() throws Exception {
        TestEvent event = new TestEvent();
        event.setAttribute("attribute", "testabc");
        event.setAttribute("correlation_id", 10);
        event.setEventType("A");
        TestEvent event2 = new TestEvent();
        event2.setAttribute("attribute", "testabc2");
        event2.setAttribute("correlation_id", 10);
        event2.setEventType("B");

        executeTest("A(attribute='testabc') -> B(attribute='testabc2' and correlation_id=A.correlation_id)", Lists.newArrayList(event, event2));

        assertThat(results.size(), is(2));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(1));
        assertThat(results.containsKey("B"), is(true));
        assertThat(results.get("B").size(), is(1));
    }

    @Test
    public void shouldEvaluateAndExpression() throws Exception {
        TestEvent event = new TestEvent();
        event.setEventType("A");
        event.setAttribute("attribute", "testabc");
        event.setAttribute("correlation_id", 10);
        TestEvent event2 = new TestEvent();
        event2.setEventType("B");
        event2.setAttribute("attribute", "testabc2");
        event2.setAttribute("correlation_id", 10);

        executeTest("A(attribute='testabc') -> B(attribute='testabc2' and correlation_id=10)", Lists.newArrayList(event, event2));

        assertThat(results.size(), is(2));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(1));
        assertThat(results.containsKey("B"), is(true));
        assertThat(results.get("B").size(), is(1));
    }

    @Test
    public void shouldEvaluateGreaterThan() throws Exception {
        TestEvent event = new TestEvent();
        event.setAttribute("attribute", 20);
        event.setEventType("A");

        executeTest("A(attribute > 10)", Lists.newArrayList(event));

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(1));
    }

    @Test
    public void shouldEvaluateLowerThan() throws Exception {
        TestEvent event = new TestEvent();
        event.setAttribute("attribute", 5);
        event.setEventType("A");

        executeTest("A(attribute < 10)", Lists.newArrayList(event));

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(1));
    }

    @Test
    public void shouldEvaluateLowerThanEquals() throws Exception {
        TestEvent event = new TestEvent();
        event.setAttribute("attribute", 10);
        event.setEventType("A");

        executeTest("A(attribute <= 10)", Lists.newArrayList(event));

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(1));
    }

    @Test
    public void shouldEvaluateGreaterThanEquals() throws Exception {
        TestEvent event = new TestEvent();
        event.setEventType("A");
        event.setAttribute("attribute", 10);

        executeTest("A(attribute >= 10)", Lists.newArrayList(event));

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(1));
    }

    @Test
    public void shouldEvaluateNotEquals() throws Exception {
        TestEvent event = new TestEvent();
        event.setAttribute("attribute", 20);
        event.setEventType("A");

        executeTest("A(attribute != 10)", Lists.newArrayList(event));

        assertThat(results.size(), is(1));
        assertThat(results.containsKey("A"), is(true));
        assertThat(results.get("A").size(), is(1));
    }

    @Test
    public void shouldEvaluateWithinTimeWindow() throws Exception {
        shouldEvaluateWithinTimeWindowBase(6002L, 2);
    }

    @Test
    public void shouldEvaluateWithinTimeout() throws Exception {
        shouldEvaluateWithinTimeWindowBase(6005L, 0);
    }

    @Test
    public void shouldEvaluateUntilCondition() throws Exception {
        TestEvent event = new TestEvent();
        event.setAttribute("attribute", "testabc");
        event.setAttribute("stop", false);
        event.setEventType("A");
        TestEvent event2 = new TestEvent();
        event2.setEventType("A");
        event2.setAttribute("attribute", "testabc");
        event2.setAttribute("stop", false);
        TestEvent event3 = new TestEvent();
        event3.setEventType("A");
        event3.setAttribute("attribute", "testabc");
        event3.setAttribute("stop", true);

        String pattern = "A{1,+}?(attribute='testabc')[stop=true]";

        executeTest(pattern, Lists.newArrayList(event, event2, event3));

        assertThat(results.size(), is(1));
        assertThat(results.get("A").size(), is(2));
    }

    @Test
    public void shouldEvaluateUntilCondition2() throws Exception {
        TestEvent event = new TestEvent();
        event.setAttribute("attribute", "testabc");
        event.setAttribute("stop", false);
        event.setEventType("A");
        TestEvent event2 = new TestEvent();
        event2.setEventType("A");
        event2.setAttribute("attribute", "testabc");
        event2.setAttribute("stop", false);
        TestEvent event3 = new TestEvent();
        event3.setEventType("A");
        event3.setAttribute("attribute", "testabc");
        event3.setAttribute("stop", true);

        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Event> eventDataStream = streamExecutionEnvironment.fromCollection(Lists.newArrayList(event,event2,event3));

        PatternStream<Event> eventPatternStream = CEP.pattern(eventDataStream, Pattern.<Event>begin("A").where(new SimpleCondition<Event>() {

            @Override
            public boolean filter(Event event) throws Exception {
                return event.getAttribute("attribute").get().equals("testabc");
            }
        }).oneOrMore().greedy().until(new IterativeCondition<Event>() {
            @Override
            public boolean filter(Event value, Context<Event> ctx) throws Exception {
                return value.getAttribute("stop").get().equals(true);
            }
        }));

        eventPatternStream.select(new PatternSelectFunction<Event, Event>() {
            private static final long serialVersionUID = 7242171752905668044L;

            @Override
            public Event select(Map<String, List<Event>> map) {
                results.putAll(map);
                return null;
            }
        });

        streamExecutionEnvironment.execute("test");

        assertThat(results.size(), is(2));
    }

    private void shouldEvaluateWithinTimeWindowBase(Long secondEventTimeStamp, int expected) throws Exception {
        TestEvent event = new TestEvent();
        event.setAttribute("time", 6000L);
        event.setAttribute("correlation_id", 10);
        event.setAttribute("attribute", "testabc");
        event.setEventType("A");
        TestEvent event2 = new TestEvent();
        event2.setEventType("B");
        event2.setAttribute("attribute", "testabc2");
        event2.setAttribute("correlation_id", 10);
        event2.setAttribute("time", secondEventTimeStamp);

        String pattern = "A(attribute='testabc') -> B(attribute='testabc2' and correlation_id=A.correlation_id) within 3ms";

        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        streamExecutionEnvironment.setStreamTimeCharacteristic(TimeCharacteristic.EventTime);
        streamExecutionEnvironment.setParallelism(1);

        DataStream<Event> eventDataStream = streamExecutionEnvironment.fromCollection(Arrays.asList(event, (Event)event2)).assignTimestampsAndWatermarks(new AssignerWithPunctuatedWatermarks<Event>() {
            private static final long serialVersionUID = 1565707509951005766L;

            @Nullable
            @Override
            public Watermark checkAndGetNextWatermark(Event event, long l) {
                return event.getAttribute("time").map(attribute -> {
					long watermark = (long)attribute;
					return new Watermark(watermark - WATERMARK_OFFSET);
				}).orElse(null);
            }

            @Override
            public long extractTimestamp(Event event, long watermark) {
                return event.getAttribute("time").map(attribute -> (long)attribute).orElse(0L);
            }
        });

        PatternStream<Event> patternStream = Dsl.withStrictEventTypeMatching().compile(pattern, eventDataStream);

        patternStream.select(new PatternSelectFunction<Event, Event>() {
            private static final long serialVersionUID = 7242171752905668044L;

            @Override
            public Event select(Map<String, List<Event>> map) {
                results.putAll(map);
                return null;
            }
        });

        streamExecutionEnvironment.execute("test");

        assertThat(results.size(), is(expected));
    }

    private List<Event> generate(int amount) {
        List<Event> events = new ArrayList<>();
        for(int i = 0;  i < amount; i++) {
            TestEvent event = new TestEvent();
            event.setEventType("A");
            event.setAttribute("attribute", "testabc");
            events.add(event);
        }
        return events;
    }

    private void executeTest(String pattern, List<Event> data) throws Exception {

        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Event> eventDataStream = streamExecutionEnvironment.fromCollection(data);

        PatternStream<Event> patternStream = Dsl.compile(pattern, eventDataStream);

        patternStream.select(new PatternSelectFunction<Event, Event>() {
            private static final long serialVersionUID = 7242171752905668044L;

            @Override
            public Event select(Map<String, List<Event>> map) {
                results.putAll(map);
                return null;
            }
        });

        streamExecutionEnvironment.execute("test");
    }
}
