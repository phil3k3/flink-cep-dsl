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

* String 'abc'
* Integer 30

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


## Examples

* Simple Condition

```
Sensor(temperature > 30)
```

* Correlation

```
Sensor1(temperature > 30) -> Sensor2(temperature > 50 and id=Sensor1.id)
 ```
 
## Known Issues
 
Currently the greedy tests fail due to an issue in Flink 1.4.0:
https://issues.apache.org/jira/browse/FLINK-8914
