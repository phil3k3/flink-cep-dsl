package at.datasciencelabs.pattern;

import org.apache.flink.cep.pattern.conditions.IterativeCondition;

import java.util.ArrayList;

public class ExpressionList extends ArrayList<ExpressionInterface> implements ExpressionInterface {

    private boolean isAnd;

    private ExpressionList(boolean isAnd) {
        this.isAnd = isAnd;
    }

    public static ExpressionList and() {
        return new ExpressionList(true);
    }

    public static ExpressionList or() {
        return new ExpressionList(false);
    }

    @Override
    public boolean evaluate(Event event, IterativeCondition.Context<Event> context) {
        if (isAnd) {
            return this.stream().allMatch(k -> k.evaluate(event, context));
        }
        else {
            return this.stream().anyMatch(k -> k.evaluate(event, context));
        }
    }
}
