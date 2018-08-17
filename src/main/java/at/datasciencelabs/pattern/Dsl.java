package at.datasciencelabs.pattern;

import at.datasciencelabs.pattern.generated.PatternLanguageLexer;
import at.datasciencelabs.pattern.generated.PatternLanguageParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.cep.pattern.Pattern;
import org.apache.flink.streaming.api.datastream.DataStream;

/**
 * Utility class for complex event processing using a Dsl expression.
 *
 * <p>Methods which transform a {@link DataStream} into a {@link PatternStream} to do CEP.
 */
public class Dsl {

    /**
     * Enable strict event type matching. The class identifier in the expression must
     * match the event type. HostActive(hostname='abc') only matches when there is an
     * an event which has the event type 'HostActive'.
     */
    public static DslBuilder withStrictEventTypeMatching() {
        return new DslBuilder(true);
    }

    public static class DslBuilder<T> {
        private boolean strictEventTypeMatching;

        DslBuilder(boolean strictEventTypeMatching) {
            this.strictEventTypeMatching = strictEventTypeMatching;
        }

        public PatternStream<? extends Event> compile(String expression, DataStream<? extends Event> dataStream) {
            return Dsl.compile(expression, dataStream, strictEventTypeMatching);
        }
    }


    /**
     * Returns a pattern stream based on a data stream and a pattern to search for
     * @param expression The expression representing the pattern which should be evaluated, refer to the projects documentation on syntax and features
     * @param dataStream The data stream which should be evaluated
     * @return The pattern stream providing the found patterns
     */
    public static <T extends Event> PatternStream<T> compile(String expression, DataStream<T> dataStream) {
        return Dsl.compile(expression, dataStream, false);
    }

    private static <T extends Event> PatternStream<T> compile(String expression, DataStream<T> dataStream, boolean strictEventTypeMatching) {

        CaseInsensitiveInputStream inputStream = new CaseInsensitiveInputStream(expression);
        PatternLanguageLexer lexer = new PatternLanguageLexer(inputStream);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PatternLanguageParser parser = new PatternLanguageParser(tokens);
        ParseTree parseTree = parser.patternExpression();

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        FlinkCepPatternLanguageListener listener = new FlinkCepPatternLanguageListener(strictEventTypeMatching);
        parseTreeWalker.walk(listener, parseTree);

        return CEP.pattern(dataStream, (Pattern<T, ?>) listener.getPattern());
    }
}
