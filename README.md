# Advent of Code

Therein lies my solutions to the [Advent of Code](https://adventofcode.com/).
They are ordered by year, then by day.

For each puzzle, I usually try to make part two retro-compatible with part one.

## How to use

Tests are written in Java. The build tool is Maven.
Each year, I update the language version to play with the latest features.

So you need to have a recent JDK and Maven installed on your machine.

As advised by [the rules](https://adventofcode.com/2025/about), the puzzle inputs are not included.
Each test expects the input to be placed in a file named "input" in the same package.

For instance, my layout:
```
src/main
 ├─ java
 │   └─ fr/lbroquet/adventofcode2025
 │       └─ day1
 │           └─ Main.java   <--------- puzzle code
 └─ resources   <--------------------- Git-ignored
     └─ fr/lbroquet/adventofcode2025
         └─ day1
             └─ input   <------------- puzzle input
```
I recommend laying out your inputs in the aforementioned fashion, then running the following commands:
```bash
mvn compile
java -cp target/classes fr.lbroquet.adventofcode2025.day1.Main
```
