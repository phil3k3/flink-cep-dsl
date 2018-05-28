package at.datasciencelabs.pattern;

import org.apache.flink.cep.pattern.conditions.IterativeCondition;

/**
 * Matches a single event against its context.
 */
public interface ContextMatcher {

    /**
     * Evaluate the event and compare it with the context.
     * @param event The event which should be matched
     * @param context The context of the CEP engine which provides events already matched.
     * @return True if the event matches according to its context, otherwise false.
     */
    boolean matches(Event event, IterativeCondition.Context<Event> context);
}
