package at.datasciencelabs.pattern;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.IntStream;

import java.util.Locale;

public class CaseInsensitiveInputStream extends ANTLRInputStream {
    private final char[] la;

    public CaseInsensitiveInputStream(String input) {
        super(input);
        la = input.toLowerCase(Locale.ENGLISH).toCharArray();
    }

    @Override
    public int LA(int i) {
        if (i == 0) {
            return 0;
        }
        if (i < 0) {
            i++;
            if ((p + i - 1) < 0) {
                return IntStream.EOF;
            }
        }

        if ((p + i - 1) >= n) {
            return IntStream.EOF;
        }

        return la[p + i - 1];
    }
}
