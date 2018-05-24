package at.datasciencelabs.pattern;

import org.apache.flink.cep.pattern.conditions.IterativeCondition;

public class EvaluationCondition extends IterativeCondition<Event> {


    private ExpressionList condition;

    public EvaluationCondition(ExpressionList condition) {
        this.condition = condition;
    }


    @Override
    public boolean filter(Event event, Context<Event> context) throws Exception {
        return condition.stream().allMatch(k -> k.evaluate(event));
    }
}
