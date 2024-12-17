package fr.lbroquet.adventofcode2024.day15;

import java.util.function.Function;
import java.util.stream.*;

class Warehouse {
    private final char[][] map;
    private Position robot;

    Warehouse(char[][] map) {
        this.map = Stream.of(map).map(char[]::clone).toArray(char[][]::new);
        robot = findRobot();
    }

    private Position findRobot() {
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[0].length; column++) {
                if (map[row][column] == '@') {
                    return new Position(row, column);
                }
            }
        }
        throw new IllegalArgumentException("No robot found");
    }

    public void moveRobot(char[] movements) {
        for (char movement : movements) {
            switch (movement) {
                case '^' -> moveRobotAlong(p -> new Position(p.row() - 1, p.column()));
                case '>' -> moveRobotAlong(p -> new Position(p.row(), p.column() + 1));
                case 'v' -> moveRobotAlong(p -> new Position(p.row() + 1, p.column()));
                case '<' -> moveRobotAlong(p -> new Position(p.row(), p.column() - 1));
            }
        }
    }

    private void moveRobotAlong(Function<Position, Position> nextPosition) {
        for (Position position = nextPosition.apply(robot); map[position.row()][position.column()] != '#'; position = nextPosition.apply(position)) {
            if (map[position.row()][position.column()] == '.') {
                slideToUntil(nextPosition, position);
                return;
            }
        }
    }

    private void slideToUntil(Function<Position, Position> nextPosition, Position position) {
        map[robot.row()][robot.column()] = '.';
        map[position.row()][position.column()] = 'O';
        this.robot = nextPosition.apply(robot);
        map[robot.row()][robot.column()] = '@';
    }

    public long sumOfBoxesGPS() {
        long sum = 0;
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[0].length; column++) {
                if (map[row][column] == 'O') {
                    sum += 100L * row + column;
                }
            }
        }
        return sum;
    }
}
