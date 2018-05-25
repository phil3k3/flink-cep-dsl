package at.datasciencelabs.pattern;

import org.apache.flink.cep.pattern.conditions.IterativeCondition;

/**
 * Condition for Flink CEP which evaluates a list of expressions
 */
public class EvaluationCondition extends IterativeCondition<Event> {

    private ExpressionList condition;

    EvaluationCondition(ExpressionList condition) {
        this.condition = condition;
    }


    @Override
    public boolean filter(Event event, Context<Event> context) throws Exception {
        return condition.stream().allMatch(k -> k.evaluate(event));
    }
}
