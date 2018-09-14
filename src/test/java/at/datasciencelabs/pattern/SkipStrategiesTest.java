package at.datasciencelabs.pattern;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SkipStrategiesTest {

    @Test
    public void skipPastLastEvent() throws Exception {
        List<Event> events = new ArrayList<>();
        events.add(createA());
        events.add(createA());
        events.add(createA());
        events.add(createB());

        String patternDsl = "%SKIP_PAST_LAST A1(attribute='testabc') A2(attribute='testabc') A3(attribute='testabc') B(attribute=30)";
        PatternExecutor.executeTest(patternDsl, events);

        assertThat(PatternExecutor.results.size(), is(2));
        assertThat(PatternExecutor.results.get("A1"), is(1));
        assertThat(PatternExecutor.results.get("B"), is(1));
        assertThat(PatternExecutor.results.containsKey("A2"), is(false));
        assertThat(PatternExecutor.results.containsKey("A3"), is(false));

    }

    private Event createA() {
        TestEvent testEvent = new TestEvent();
        testEvent.setAttribute("attribute", "testabc");
        testEvent.setEventType("A");
        return testEvent;
    }

    private Event createB() {
        TestEvent testEvent = new TestEvent();
        testEvent.setAttribute("attribute", 30);
        testEvent.setEventType("B");
        return testEvent;
    }

}
