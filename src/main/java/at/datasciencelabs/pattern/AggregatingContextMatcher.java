package at.datasciencelabs.pattern;

import org.apache.flink.cep.pattern.conditions.IterativeCondition;

import java.util.ArrayList;

/**
 * A context matcher which matches against a set of children contetx matchers.
 */
public class AggregatingContextMatcher extends ArrayList<ContextMatcher> implements ContextMatcher {

    private static final long serialVersionUID = 4531897679491015953L;
    private boolean isAnd;

    private AggregatingContextMatcher(boolean isAnd) {
        this.isAnd = isAnd;
    }

    /**
     * Returns a context matcher combining its children using 'and'
     * @return a new context matcher
     */
    public static AggregatingContextMatcher and() {
        return new AggregatingContextMatcher(true);
    }

    /**
     * Returns a context matcher combining its children using 'or
     * @return a new context matcher
     */
    public static AggregatingContextMatcher or() {
        return new AggregatingContextMatcher(false);
    }

    /**
     * Evaluate the event and compare it with the context.
     * @param event The event which should be matched
     * @param context The context of the CEP engine which provides events already matched.
     * @return True if the event matches according to its context, otherwise false.
     */
    @Override
    public boolean matches(Event event, IterativeCondition.Context<Event> context) {
        if (isAnd) {
            return this.stream().allMatch(k -> k.matches(event, context));
        }
        else {
            return this.stream().anyMatch(k -> k.matches(event, context));
        }
    }
}
