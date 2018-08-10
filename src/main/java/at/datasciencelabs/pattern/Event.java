package at.datasciencelabs.pattern;

import java.io.Serializable;
import java.util.Optional;

/**
 * Describes an event which occurs in the pattern stream.
 *
 * The event has a set of associated attributes.
 */
public interface Event extends Serializable {

    /**
     * Returns an attribute of the event.
     * @param attribute the name of the desired attribute.
     * @return The attribute or {@link Optional#empty()}} if not available
     */
    Optional<Object> getAttribute(String attribute);


    /**
     * Returns the type of the event.
     * @return The type of the event
     */
    String getEventType();
}
