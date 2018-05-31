package at.datasciencelabs.pattern;


import net.entropysoft.transmorph.utils.NumberComparator;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Supports evaluating a set of operators
 */
public enum Operator {
    EQUALS("=", Object::equals),
    NOT_EQUALS("!=", new Evaluator() {
        @Override
        public <T> boolean evaluate(T left, T right) {
            return !Operator.EQUALS.evaluate(left, right);
        }
    }),
    LOWER_THAN("<", new Evaluator() {
        @Override
        public <T> boolean evaluate(T left, T right) {
            return compareNumber(left, right) < 0;
        }
    }),
    LOWER_EQUALS("<=", new Evaluator() {
        @Override
        public <T> boolean evaluate(T left, T right) {
            return compareNumber(left, right) <= 0;
        }
    }),
    GREATER_THAN(">", new Evaluator() {
        @Override
        public <T> boolean evaluate(T left, T right) {
            return compareNumber(left, right) > 0;
        }
    }),
    GREATER_EQUALS(">=", new Evaluator() {
        @Override
        public <T> boolean evaluate(T left, T right) {
            return compareNumber(left, right) >= 0;
        }
    });

    private String operatorString;
    private Evaluator evaluator;

    public static Operator fromText(String operator) throws Throwable {
        return Arrays.stream(Operator.values()).filter(k -> k.operatorString.equals(operator)).findFirst().orElseThrow((Supplier<Throwable>) () -> new RuntimeException(String.format("Illegal operator '%s'", operator)));
    }

    Operator(String operatorString, Evaluator evaluator) {
        this.operatorString = operatorString;
        this.evaluator = evaluator;
    }

    public boolean evaluate(Object attribute, Object value) {
        return this.evaluator.evaluate(attribute, value);
    }

    private interface Evaluator {
        <T> boolean  evaluate(T left, T right);
    }

    private static <T> int compareNumber(T left, T right) {
        if (left instanceof Number && right instanceof Number) {
            return new NumberComparator().compare((Number)left, ((Number)right));
        }
        throw new UnsupportedOperationException("No number instance provided");
    }
}
