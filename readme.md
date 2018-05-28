# Simple Flink DSL

The idea is to have simple pattern language based
on regular expression syntax and inspired by other Stream Processing
frameworks such as Esper.

Note that all expressions are case-insensitive.

Currently the following features are supported:

## Conditions

### Operators

* Equals '='
a(attribute = 30)
* Not Equals '!='
a(attribute != 30)

### Data Types

* String 'abc'
* Integer 30

### Operators

* Equals '='

## Quantifiers

* a* Zero or More 

* a+ One or More

* a? Zero or One

* a{3} Exactly Three 

* a{3,+} Three or More

### Greediness vs Optional

* a{3}(b = 3)? Optional
* a{3}?(b = 3) Greedy


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

## Examples

* Simple Condition

```
Sensor(temperature = 30)
```

* Correlation

```
Sensor1(temperature = 30) -> Sensor2(temperature = 50 and id=Sensor1.id)
 ```
 
## Known Issues
 
Currently the greedy tests fail due to an issue in Flink 1.4.0:
https://issues.apache.org/jira/browse/FLINK-8914
