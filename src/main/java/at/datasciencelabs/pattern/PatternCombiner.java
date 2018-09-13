package at.datasciencelabs.pattern;

import org.apache.flink.cep.pattern.Pattern;

interface PatternCombiner {
	Pattern<Event, Event> combine(Pattern<Event, Event> pattern, String classIdentifier);
}
