package at.datasciencelabs.pattern;

import java.util.Optional;

/**
 * Describes an event which occors in the pattern stream.
 *
 * The event has a set of associated attributes.
 */
public interface Event {

    /**
     * Returns an attribute of the event.
     * @param attribute the name of the desired attribute.
     * @return The attribute or {@link Optional#empty()}} if not available
     */
    Optional<Object> getAttribute(String attribute);
}
