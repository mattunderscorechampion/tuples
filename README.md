# Tuples

A collection of tuples.
The tuples `n=1-3` are type safe.
A arbitrary size tuple implementation is included but it is not type safe.
All tuples support consumers, functions and mapping operations.

Tuples support null values, equality and accessing values.
All tuples are immutable.

```
Pair<String, Integer> p = Pair.of("value", 5);
p.acceptV1(System.out::println);
```
