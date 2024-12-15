package fr.lbroquet.adventofcode2024.day14;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    @Test
    void example() {
        String input = """
                p=0,4 v=3,-3
                p=6,3 v=-1,-3
                p=10,3 v=-1,2
                p=2,0 v=2,-1
                p=0,0 v=1,3
                p=3,0 v=-2,-2
                p=7,6 v=-1,-3
                p=3,0 v=-1,-2
                p=9,3 v=2,3
                p=7,3 v=-1,2
                p=2,4 v=2,-3
                p=9,5 v=-3,-3
                """;
        List<Robot> robots = Stream.of(input.split("\n")).map(Main::toRobot).toList();
        robots.forEach(robot -> robot.steps(100));
        Map<Integer, Long> countByQuadrant = robots.stream().collect(Collectors.groupingBy(Robot::quadrant, Collectors.counting()));
        assertEquals(3, countByQuadrant.get(0));
        assertEquals(1, countByQuadrant.get(1));
        assertEquals(3, countByQuadrant.get(2));
        assertEquals(4, countByQuadrant.get(3));
        assertEquals(1, countByQuadrant.get(4));
    }
}