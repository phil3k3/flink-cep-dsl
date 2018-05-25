import at.datasciencelabs.pattern.CaseInsensitiveInputStream;
import at.datasciencelabs.pattern.Event;
import at.datasciencelabs.pattern.FlinkCepPatternLanguageListener;
import at.datasciencelabs.pattern.generated.PatternLanguageLexer;
import at.datasciencelabs.pattern.generated.PatternLanguageParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternSelectFunction;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.shaded.curator.org.apache.curator.shaded.com.google.common.collect.Lists;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleTests {

    private static Map<String, List<Event>> results = new HashMap<>();

    @Before
    public void onBefore() {
        results.clear();
    }

    @Test
    public void shouldEvaluateNextPattern() throws Exception {
        Event event = new Event();
        event.addAttribute("attribute", "testabc");
        Event event2 = new Event();
        event2.addAttribute("attribute", 30);
        executeTest("A(attribute='testabc') B(attribute=30)", Lists.newArrayList(event, event2));

        assertThat(results.size(), is(2));
    }

    @Test
    public void shouldEvaluateFollowedByPattern() throws Exception {
        Event event = new Event();
        event.addAttribute("attribute", "testabc");
        Event event2 = new Event();
        event2.addAttribute("attribute", "testabc2");
        Event event3 = new Event();
        event3.addAttribute("attribute", 30);
        executeTest("A(attribute='testabc') -> B(attribute=30)", Lists.newArrayList(event, event2, event3));

        assertThat(results.size(), is(2));
    }

    private void executeTest(String pattern, List<Event> data) throws Exception {
        PatternLanguageLexer lexer = new PatternLanguageLexer(new CaseInsensitiveInputStream(pattern));

        CommonTokenStream tokens = new CommonTokenStream(lexer); // a token stream
        PatternLanguageParser parser = new PatternLanguageParser(tokens); // transforms tokens into parse trees
        ParseTree t = parser.patternExpression(); // creates the parse tree from the called rule

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        FlinkCepPatternLanguageListener flinkCepPatternLanguageListener = new FlinkCepPatternLanguageListener();
        parseTreeWalker.walk(flinkCepPatternLanguageListener, t);

        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Event> eventDataStream = streamExecutionEnvironment.fromCollection(data);

        PatternStream<Event> patternStream = CEP.pattern(eventDataStream, flinkCepPatternLanguageListener.getPattern());

        patternStream.select(new PatternSelectFunction<Event, Event>() {
            @Override
            public Event select(Map<String, List<Event>> map) throws Exception {
                results.putAll(map);
                return null;
            }
        });

        streamExecutionEnvironment.execute("test");
    }
}
