package at.datasciencelabs.pattern;

import java.io.Serializable;

/*
  Represents a single expression consisting of attribute, operator and value
 */
class Expression implements Serializable {
    private String attribute;
    private Operator operator;
    private Object value;

    Expression(Operator operator) {
        this.operator = operator;
    }

    void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    void setValue(Object value) {
        this.value = value;
    }

    boolean evaluate(Event event) {
        return operator.evaluate(event.getAttribute(attribute), value);
    }
}
