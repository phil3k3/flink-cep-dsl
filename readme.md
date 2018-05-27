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

a b

* Followed By 

a -> b

Known Issues

Currently the greedy tests fail due to an issue in Flin 1.4.0:
https://issues.apache.org/jira/browse/FLINK-8914

