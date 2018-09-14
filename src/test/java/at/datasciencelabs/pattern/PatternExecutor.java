package at.datasciencelabs.pattern;

import org.apache.flink.cep.PatternSelectFunction;
import org.apache.flink.cep.PatternStream;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PatternExecutor {

    static Map<String, List<Event>> results = new HashMap<>();

    static void executeTest(String pattern, List<Event> data) throws Exception {

        StreamExecutionEnvironment streamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<Event> eventDataStream = streamExecutionEnvironment.fromCollection(data);

        PatternStream<Event> patternStream = Dsl.compile(pattern, eventDataStream);

        patternStream.select(new PatternSelectFunction<Event, Event>() {
            private static final long serialVersionUID = 7242171752905668044L;

            @Override
            public Event select(Map<String, List<Event>> map) {
                results.putAll(map);
                return null;
            }
        });

        streamExecutionEnvironment.execute("test");
    }
}
