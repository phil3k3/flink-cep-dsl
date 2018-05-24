package at.datasciencelabs.pattern;

import java.io.Serializable;

public class Expression implements Serializable {
    public String attribute;
    public Operator operator;
    public Object value;

    public Expression(Operator operator) {
        this.operator = operator;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean evaluate(Event event) {
        return operator.evaluate(event.getAttribute(attribute), value);
    }
}
