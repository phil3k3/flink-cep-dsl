package at.datasciencelabs.pattern;

import org.apache.flink.cep.pattern.conditions.IterativeCondition;

public interface ExpressionInterface  {
    boolean evaluate(Event event, IterativeCondition.Context<Event> context);
}
