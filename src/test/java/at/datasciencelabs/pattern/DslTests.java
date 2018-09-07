package at.datasciencelabs.pattern;

import org.apache.flink.cep.PatternStream;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class DslTests {

    @Test
    public void shouldEvaluateNextPattern() throws Exception {

        DataStream<Event> dataStream = null;
        PatternStream<Event> patternStream = Dsl.compile("A(attribute='testabc') B(attribute=30)", dataStream);

        assertThat(patternStream.getPattern(), is(notNullValue()));
        assertThat(patternStream.getPattern().getName(), is("B"));
        assertThat(patternStream.getPattern().getPrevious(), is(notNullValue()));
        assertThat(patternStream.getPattern().getPrevious().getName(), is("A"));
    }

}
