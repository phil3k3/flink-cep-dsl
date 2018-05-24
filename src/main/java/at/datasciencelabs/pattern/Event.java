package at.datasciencelabs.pattern;

import java.util.HashMap;
import java.util.Map;

public class Event {

    private Map<String, Object> values  = new HashMap<>();

    public Object getAttribute(String attribute) {
        return values.get(attribute);
    }

    public void addAttribute(String attribute, Object value) {
        values.put(attribute, value);
    }
}
