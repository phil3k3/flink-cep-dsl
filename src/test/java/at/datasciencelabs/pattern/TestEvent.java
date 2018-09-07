package at.datasciencelabs.pattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TestEvent implements Event {

    private static final long serialVersionUID = 5458760078762352571L;
    private Map<String, Object> attributes = new HashMap<>();
    private String eventType;

    void setAttribute(String attribute, Object value) {
        this.attributes.put(attribute, value);
    }

    @Override
    public Optional<Object> getAttribute(String attribute) {
        if (attribute.contains(attribute)) {
            return Optional.of(attributes.get(attribute));
        }
        return Optional.empty();
    }

    @Override
    public String getEventType() {
        return this.eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }
}
