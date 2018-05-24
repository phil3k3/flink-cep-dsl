import at.datasciencelabs.pattern.CaseInsensitiveInputStream;
import at.datasciencelabs.pattern.Event;
import at.datasciencelabs.pattern.PatternLanguageConcreteListener;
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
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SimpleTests {

    @Test
    public void testSimpleParse() throws Exception {
        PatternLanguageLexer lexer = new PatternLanguageLexer(new CaseInsensitiveInputStream("A(attribute='testabc') B(attribute=30"));

        CommonTokenStream tokens = new CommonTokenStream(lexer); // a token stream
        PatternLanguageParser parser = new PatternLanguageParser(tokens); // transforms tokens into parse trees
        ParseTree t = parser.patternExpression(); // creates the parse tree from the called rule

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        PatternLanguageConcreteListener patternLanguageConcreteListener = new PatternLanguageConcreteListener();
        parseTreeWalker.walk(patternLanguageConcreteListener, t);

        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();
        Event event = new Event();
        event.addAttribute("attribute", "testabc");
        Event event2 = new Event();
        event2.addAttribute("attribute", 30);
        DataStream<Event> eventDataStream = streamExecutionEnvironment.fromCollection(Lists.newArrayList(event, event2));

        PatternStream<Event> patternStream = CEP.pattern(eventDataStream, patternLanguageConcreteListener.getPattern());

        patternStream.select(new PatternSelectFunction<Event, Event>() {
            @Override
            public Event select(Map<String, List<Event>> map) throws Exception {
                return map.get(map.keySet().iterator().next()).get(0);
            }
        }).print();

        streamExecutionEnvironment.execute("test");

    }
}
