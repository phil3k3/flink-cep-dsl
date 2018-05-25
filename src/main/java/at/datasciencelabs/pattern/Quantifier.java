package at.datasciencelabs.pattern;

import org.apache.flink.cep.pattern.Pattern;

public class Quantifier {

    private boolean oneOrMore;
    private boolean greedy;
    private boolean optional;
    private boolean zeroOrMore;

    private Integer lowerBound;
    private Integer upperBound;

    public Pattern<Event, Event> apply(Pattern<Event, Event> pattern) {
        if (optional) {
            pattern = pattern.optional();
        }
        if (greedy) {
            pattern = pattern.greedy();
        }
        if (oneOrMore) {
            pattern = pattern.oneOrMore();
        }
        if (zeroOrMore) {
            pattern = pattern.oneOrMore().optional();
        }
        if (lowerBound != null && upperBound == null) {
            pattern = pattern.times(lowerBound);
        }
        if (lowerBound != null && upperBound != null) {
            if (upperBound < Integer.MAX_VALUE) {
                pattern = pattern.times(lowerBound, upperBound);
            }
            else {
                pattern = pattern.timesOrMore(lowerBound);
            }
        }
        return pattern;
    }

    public static class Builder {

        private Quantifier quantifier = new Quantifier();

        public Quantifier.Builder greedy() {
            quantifier.greedy = true;
            return this;
        }

        public Quantifier build() {
            return quantifier;
        }

        public Builder oneOrMore() {
            quantifier.oneOrMore = true;
            return this;
        }

        public Builder zeroOrMore() {
            quantifier.zeroOrMore = true;
            return this;
        }

        public Builder bound(int timesOrValue) {
            if (quantifier.lowerBound != null) {
                quantifier.upperBound = timesOrValue;
            }
            else {
                quantifier.lowerBound = timesOrValue;
            }

            return this;
        }

        public Builder optional() {
            quantifier.optional = true;
            return this;
        }
    }

}
