package at.datasciencelabs.pattern;

import at.datasciencelabs.pattern.generated.PatternLanguageLexer;
import at.datasciencelabs.pattern.generated.PatternLanguageParser;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.flink.cep.CEP;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.streaming.api.datastream.DataStream;

public class Pattern {

    /**
     * Returns a pattern stream based on a data stream and a pattern to search for
     * @param pattern The pattern which should be evaluated, refer to the projects documentation on syntax and features
     * @param dataStream The data stream which should be evaluated
     * @return The pattern stream providing the found patterns
     */
    public static PatternStream<Event> transform(String pattern, DataStream<Event> dataStream) {
        PatternLanguageLexer lexer = new PatternLanguageLexer(new CaseInsensitiveInputStream(pattern));

        CommonTokenStream tokens = new CommonTokenStream(lexer); // a token stream
        PatternLanguageParser parser = new PatternLanguageParser(tokens); // transforms tokens into parse trees
        ParseTree t = parser.patternExpression(); // creates the parse tree from the called rule

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        FlinkCepPatternLanguageListener flinkCepPatternLanguageListener = new FlinkCepPatternLanguageListener();
        parseTreeWalker.walk(flinkCepPatternLanguageListener, t);

        return CEP.pattern(dataStream, flinkCepPatternLanguageListener.getPattern());
    }
}
