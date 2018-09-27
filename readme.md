# Simple Flink DSL

The idea is to have simple pattern language based
on regular expression syntax and inspired by other Stream Processing
frameworks such as Esper.

Note that all expressions are case-insensitive.

# Building

This is a maven project, so to build you simply:

```
mvn install -DskipTests
```

# Usage

```java
DataStream<Event> eventDataStream = ...
PatternStream<Event> patternStream = Dsl.compile("Sensor(temperature > 30)", eventDataStream);
patternStream.select(new PatternSelectFunction<Event, Event>() {
                          @Override
                          public Event select(Map<String, List<Event>> map) throws Exception {
                              return map.get("Sensor");
                          }
                      })

```


Currently the following features are supported:

## Conditions

### Operators

* Equals
```
a(attribute = 30)
```
* Not Equals
```
a(attribute != 30)
```
* Lower Than
```
a(attribute < 30)
```
* Greater Than
```
a(attribute > 30)
```
* Lower Than or Equals
```
a(attribute <= 30)
```
* Greater Than or Equals
```
a(attribute >= 30)
```

### Data Types

* String literals 'abc'
* Integer literals 30
* Boolean literals true false

## Quantifiers

* Zero or More
 ```
 a*
 ```
* One or More
```
a+
```
* Zero or One
```
a?
```
* Exactly Three
```
 a{3}
```
* Three or More
```
 a{3,+}
```

### Greediness vs Optional

* Optional
```
a{3}(b = 3)?
 ```
* Greedy
```
a{3}?(b = 3)
```
 


## Patterns

* Next:

```
a b
```

* Followed By 

```
a -> b
```

* Followed By Any

```
a ->> b
```

## Where vs Until

Flink supports a where clause as well as an until clause to define 
a stop condition for a looping pattern.

* Where
```
Sensor(temperature > 30)
```

* Until
```
Sensor[temperature <= 30]
```

The two operators can also be combined.

```
Sensor(temperature > 30)[resolved=false]
```

## Examples

* Simple Condition

```
Sensor(temperature > 30)
```

* Correlation

```
Sensor1(temperature > 30) -> Sensor2(temperature > 50 and id=Sensor1.id)
```
 
## After Match Skip Strategies

* No Skip
```
%NO_SKIP
A+(attribute='testabc') B(attribute=30)
```
* Skip Past Last
```
%SKIP_PAST_LAST
A+(attribute='testabc') B(attribute=30)
```
* Skip to Last
```
%SKIP_TO_LAST['A']
A+(attribute='testabc') B(attribute=30)
```
* Skip To First
```
%SKIP_TO_FIRST['A']
A+(attribute='testabc') B(attribute=30)
```

For details regarding semantics refer to https://ci.apache.org/projects/flink/flink-docs-stable/dev/libs/cep.html#after-match-skip-strategy
 
## Known Issues
 
Currently the greedy operator does not work when applied to the first event
in the pattern. 

Works
```
TransportStarted(destination = 'Vienna') LocationUpdate{1,+}?(destination=TransportStarted.destination) TransportEnded(destination=TransportStarted.destination)
```

Does not Work
```
LocationUpdate{1,+}? TransportEnded(destination=LocationUpdate.destination)
```

See https://issues.apache.org/jira/browse/FLINK-8914 for details.