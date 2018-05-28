package at.datasciencelabs.pattern;


import net.entropysoft.transmorph.utils.NumberComparator;

/**
 * Supports evaluating a set of operators
 */
public enum Operator {
    EQUALS(Object::equals),
    NOT_EQUALS(new Evaluator() {
        @Override
        public <T> boolean evaluate(T left, T right) {
            return !Operator.EQUALS.evaluate(left, right);
        }
    }),
    LOWER_THAN(new Evaluator() {
        @Override
        public <T> boolean evaluate(T left, T right) {
            return compareNumber(left, right) < 0;
        }
    }),
    LOWER_EQUALS(new Evaluator() {
        @Override
        public <T> boolean evaluate(T left, T right) {
            return compareNumber(left, right) <= 0;
        }
    }),
    GREATER_THAN(new Evaluator() {
        @Override
        public <T> boolean evaluate(T left, T right) {
            return compareNumber(left, right) > 0;
        }
    }),
    GREATER_EQUALS(new Evaluator() {
        @Override
        public <T> boolean evaluate(T left, T right) {
            return compareNumber(left, right) >= 0;
        }
    });

    private static <T> int compareNumber(T left, T right) {
        if (left instanceof Number && right instanceof Number) {
			return new NumberComparator().compare((Number)left, ((Number)right));
		}
        throw new UnsupportedOperationException("No number instance provided");
    }

    private Evaluator evaluator;

    Operator(Evaluator evaluator) {
        this.evaluator = evaluator;
    }

    public boolean evaluate(Object attribute, Object value) {
        return this.evaluator.evaluate(attribute, value);
    }

    private interface Evaluator {
        <T> boolean  evaluate(T left, T right);
    }
}
