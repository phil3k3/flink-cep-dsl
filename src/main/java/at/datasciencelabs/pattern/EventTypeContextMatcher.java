package at.datasciencelabs.pattern;

import java.io.Serializable;
import org.apache.flink.cep.pattern.conditions.IterativeCondition;

/**
 * Matches a certain event type
 */
public class EventTypeContextMatcher implements ContextMatcher, Serializable {

	private static final long serialVersionUID = 5895353788448301893L;
	private String eventType;

	private EventTypeContextMatcher(String text) {
		this.eventType = text;
	}

	static EventTypeContextMatcher matching(String text) {
		return new EventTypeContextMatcher(text);
	}

	static EventTypeContextMatcher ignoring() {
		return new EventTypeContextMatcher(null);
	}

	@Override
	public boolean matches(Event event, IterativeCondition.Context<Event> context) {
		// always match when there is no strict type set
		if (this.eventType == null) {
			return true;
		}

		String eventType = event.getEventType();
		if (eventType != null) {
			return eventType.equals(this.eventType);
		}
		// when there is no type provided, assume it never matches.
		return false;
	}
}
