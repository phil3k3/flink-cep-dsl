package at.datasciencelabs.pattern;

import org.apache.flink.cep.pattern.conditions.IterativeCondition;

/**
 * Condition for Flink CEP which evaluates a list of expressions
 */
public class EvaluationCondition extends IterativeCondition<Event> {

    private static final long serialVersionUID = -2634553039575827744L;
    private AggregatingContextMatcher contextMatchers;

    EvaluationCondition(AggregatingContextMatcher contextMatchers) {
        this.contextMatchers = contextMatchers;
    }

    @Override
    public boolean filter(Event event, Context<Event> context) {
        return contextMatchers.matches(event, context);
    }
}
