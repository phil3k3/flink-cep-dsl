package at.datasciencelabs.pattern;

import org.apache.flink.cep.pattern.conditions.IterativeCondition;

import java.io.Serializable;

/*
  Represents a single expression consisting of attribute, operator and value
 */
class Expression implements Serializable, ExpressionInterface {
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

    public boolean evaluate(Event event, IterativeCondition.Context<Event> context) {
        return operator.evaluate(event.getAttribute(attribute), value);
    }
}
