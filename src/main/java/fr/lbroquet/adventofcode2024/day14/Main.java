package fr.lbroquet.adventofcode2024.day14;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    static final int SPACE_X = 101;
    static final int SPACE_Y = 103;

    private static final Pattern ROBOT = Pattern.compile("p=(?<x>\\d+),(?<y>\\d+) v=(?<vx>-?\\d+),(?<vy>-?\\d+)");

    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            List<Robot> robots = reader.lines().map(Main::toRobot).toList();
            for (int second = 1; second <= 10000; second++) {
                robots.forEach(robot -> robot.steps(1));
                Map<Integer, Long> countByQuadrant = robots.stream().collect(groupingBy(Robot::quadrant, counting()));
                countByQuadrant.remove(0);
                long safetyFactor = countByQuadrant.values().stream().mapToLong(Long::longValue).reduce(1, Math::multiplyExact);
                System.out.printf("Safety factor @%d: %d%n", second, safetyFactor);
                if (safetyFactor < 200000000) {
                    show(robots);
                }
            }
        }
    }

    private static void show(List<Robot> robots) {
        char[][] map = new char[SPACE_Y][SPACE_X];
        for (Robot robot : robots) {
            map[robot.y][robot.x] = '#';
        }
        StringBuilder s = new StringBuilder();
        for (char[] row : map) {
            for (char cell : row) {
                s.append(cell == '\0' ? ' ' : cell);
            }
            s.append('\n');
        }
        IO.println(s);
    }

    static Robot toRobot(String s) {
        Matcher matcher = ROBOT.matcher(s);
        if (matcher.matches()) {
            int x = Integer.parseInt(matcher.group("x"));
            int y = Integer.parseInt(matcher.group("y"));
            int vx = Integer.parseInt(matcher.group("vx"));
            int vy = Integer.parseInt(matcher.group("vy"));
            return new Robot(x, y, vx, vy);
        }
        throw new IllegalArgumentException(s);
    }
}
