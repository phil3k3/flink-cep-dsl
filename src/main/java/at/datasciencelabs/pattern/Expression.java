package at.datasciencelabs.pattern;

import org.apache.flink.cep.pattern.conditions.IterativeCondition;
import org.apache.flink.shaded.curator.org.apache.curator.shaded.com.google.common.base.Strings;
import org.apache.flink.shaded.curator.org.apache.curator.shaded.com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.function.Supplier;

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

    void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    void setValue(Object value) {
        this.value = value;
    }

    void setOperator(Operator operator) {
        this.operator = operator;
    }

    public boolean matches(Event event, IterativeCondition.Context<Event> context) {
        try {
            Object attribute = event.getAttribute(this.attribute).orElseThrow((Supplier<Throwable>) () -> new RuntimeException("Attribute does not exiyt"));
            return operator.evaluate(attribute, getValue(context));
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    private Object getValue(IterativeCondition.Context<Event> context) {
        if (Strings.isNullOrEmpty(valueClassIdentifier) || Strings.isNullOrEmpty(valueAttribute)) {
            return value;
        }
        try {
            List<Event> contextEvents = Lists.newArrayList(context.getEventsForPattern(valueClassIdentifier));
            if (contextEvents.size() > 0) {
                Event first = contextEvents.get(0);
                return first.getAttribute(valueAttribute).orElseThrow((Supplier<Throwable>) () -> new RuntimeException("Attribute does not exist"));
            }
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
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
