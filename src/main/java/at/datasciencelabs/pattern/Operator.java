package at.datasciencelabs.pattern;

public enum Operator {
    EQUALS(Object::equals),
    NOT_EQUALS(new Evaluator() {
        @Override
        public <T> boolean evaluate(T left, T right) {
            return !Operator.EQUALS.evaluate(left, right);
        }
    });

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
