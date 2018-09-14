package at.datasciencelabs.pattern;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SkipStrategiesTest {

    private List<Event> events;

    @Before
    public void before() {
        PatternExecutor.results.clear();
        events = new ArrayList<>();
        events.add(createA());
        events.add(createA());
        events.add(createA());
        events.add(createB());
    }

    @Test
    public void skipPastLastEvent() throws Exception {
        String patternDsl = "%SKIP_PAST_LAST\nA+(attribute='testabc') B(attribute=30)";
        PatternExecutor.executeTest(patternDsl, events);

        assertThat(PatternExecutor.results.size(), is(1));
        assertThat(PatternExecutor.results.get(0).size(), is(2));
        assertThat(PatternExecutor.results.get(0).get("A").size(), is(3));
        assertThat(PatternExecutor.results.get(0).get("B").size(), is(1));
    }

    @Test
    public void skipNoSkip() throws Exception {
        String patternDsl = "%NO_SKIP\nA+(attribute='testabc') B(attribute=30)";
        PatternExecutor.executeTest(patternDsl, events);

        assertThat(PatternExecutor.results.size(), is(3));
        assertThat(PatternExecutor.results.get(0).size(), is(2));
        assertThat(PatternExecutor.results.get(0).get("A").size(), is(3));
        assertThat(PatternExecutor.results.get(0).get("B").size(), is(1));

        assertThat(PatternExecutor.results.get(1).size(), is(2));
        assertThat(PatternExecutor.results.get(1).get("A").size(), is(2));
        assertThat(PatternExecutor.results.get(1).get("B").size(), is(1));

        assertThat(PatternExecutor.results.get(2).size(), is(2));
        assertThat(PatternExecutor.results.get(2).get("A").size(), is(1));
        assertThat(PatternExecutor.results.get(2).get("B").size(), is(1));
    }

    @Test
    public void skipToFirst() throws Exception {
        String patternDsl = "%SKIP_TO_FIRST['A']\nA+(attribute='testabc') B(attribute=30)";
        PatternExecutor.executeTest(patternDsl, events);

        assertThat(PatternExecutor.results.size(), is(3));
        assertThat(PatternExecutor.results.get(0).size(), is(2));
        assertThat(PatternExecutor.results.get(0).get("A").size(), is(3));
        assertThat(PatternExecutor.results.get(0).get("B").size(), is(1));

        assertThat(PatternExecutor.results.get(1).size(), is(2));
        assertThat(PatternExecutor.results.get(1).get("A").size(), is(2));
        assertThat(PatternExecutor.results.get(1).get("B").size(), is(1));

        assertThat(PatternExecutor.results.get(2).size(), is(2));
        assertThat(PatternExecutor.results.get(2).get("A").size(), is(1));
        assertThat(PatternExecutor.results.get(2).get("B").size(), is(1));
    }

    @Test
    public void skipToLast() throws Exception {
        String patternDsl = "%SKIP_TO_LAST['A']\nA+(attribute='testabc') B(attribute=30)";
        PatternExecutor.executeTest(patternDsl, events);

        assertThat(PatternExecutor.results.size(), is(2));
        assertThat(PatternExecutor.results.get(0).size(), is(2));
        assertThat(PatternExecutor.results.get(0).get("A").size(), is(3));
        assertThat(PatternExecutor.results.get(0).get("B").size(), is(1));

        assertThat(PatternExecutor.results.get(1).size(), is(2));
        assertThat(PatternExecutor.results.get(1).get("A").size(), is(1));
        assertThat(PatternExecutor.results.get(1).get("B").size(), is(1));
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
