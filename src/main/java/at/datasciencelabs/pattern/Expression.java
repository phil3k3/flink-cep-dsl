package at.datasciencelabs.pattern;

import org.apache.flink.cep.pattern.conditions.IterativeCondition;
import org.apache.flink.shaded.curator.org.apache.curator.shaded.com.google.common.base.Strings;
import org.apache.flink.shaded.curator.org.apache.curator.shaded.com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;

/*
  Represents a single expression consisting of attribute, operator and value
  The value can be a single value or a reference to another event. The reference
  is provided by the class identifier of the corresponding previous pattern and
  an attribute of an event.
 */
class Expression implements Serializable, ContextMatcher {

    private String attribute;
    private Operator operator;
    private Object value;
    private String valueClassIdentifier;
    private String valueAttribute;

    Expression(Operator operator) {
        this.operator = operator;
    }

    void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    void setValue(Object value) {
        this.value = value;
    }

    public boolean matches(Event event, IterativeCondition.Context<Event> context) {
        return operator.evaluate(event.getAttribute(attribute), getValue(context));
    }

    private Object getValue(IterativeCondition.Context<Event> context) {
        if (Strings.isNullOrEmpty(valueClassIdentifier) || Strings.isNullOrEmpty(valueAttribute)) {
            return value;
        }
        List<Event> contextEvents = Lists.newArrayList(context.getEventsForPattern(valueClassIdentifier));
        if (contextEvents.size() > 0) {
            Event first = contextEvents.get(0);
            return first.getAttribute(valueAttribute);
        }
        return null;
     }

    boolean hasAttribute() {
        return !Strings.isNullOrEmpty(attribute);
    }

    void setValueClassIdentifier(String valueClassIdentifier) {
        this.valueClassIdentifier = valueClassIdentifier;
    }

    boolean hasValueClassIdentiifer() {
        return !Strings.isNullOrEmpty(valueClassIdentifier);
    }

    void setValueAttribute(String valueAttribute) {
        this.valueAttribute = valueAttribute;
    }
}
