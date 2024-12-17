package fr.lbroquet.adventofcode2024.day15;

import java.util.ArrayList;
import java.util.List;

class WideWarehouse {
    private final char[][] map;
    private Position robot;

    public WideWarehouse(char[][] map) {
        this.map = widen(map);
        robot = findRobot();
    }

    private char[][] widen(char[][] map) {
        List<char[]> wideMap = new ArrayList<>();
        for (char[] row : map) {
            char[] wideRow = new char[row.length * 2];
            for (int column = 0; column < map[0].length; column++) {
                if (row[column] == '#') {
                    wideRow[2 * column] = '#';
                    wideRow[2 * column + 1] = '#';
                }
                if (row[column] == 'O') {
                    wideRow[2 * column] = '[';
                    wideRow[2 * column + 1] = ']';
                }
                if (row[column] == '.') {
                    wideRow[2 * column] = ' ';
                    wideRow[2 * column + 1] = ' ';
                }
                if (row[column] == '@') {
                    wideRow[2 * column] = '@';
                    wideRow[2 * column + 1] = ' ';
                }
            }
            wideMap.add(wideRow);
        }
        return wideMap.toArray(char[][]::new);
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
                case '^' -> moveRobotUp();
                case '>' -> moveRobotRight();
                case 'v' -> moveRobotDown();
                case '<' -> moveRobotLeft();
            }
        }
    }

    private void moveRobotUp() {
        if (freeSpaceUpOf(robot)) {
            moveUp(robot);
            robot = new Position(robot.row() - 1, robot.column());
        }
    }

    private boolean freeSpaceUpOf(Position position) {
        Position up = new Position(position.row() - 1, position.column());
        if (map[up.row()][up.column()] == '#') {
            return false;
        }
        if (map[up.row()][up.column()] == '[') {
            return freeSpaceUpOf(up) && freeSpaceUpOf(new Position(up.row(), up.column() + 1));
        }
        if (map[up.row()][up.column()] == ']') {
            return freeSpaceUpOf(up) && freeSpaceUpOf(new Position(up.row(), up.column() - 1));
        }
        return true;
    }

    private void moveUp(Position position) {
        Position up = new Position(position.row() - 1, position.column());
        if (map[up.row()][up.column()] == '[') {
            moveUp(up);
            moveUp(new Position(up.row(), up.column() + 1));
        }
        if (map[up.row()][up.column()] == ']') {
            moveUp(up);
            moveUp(new Position(up.row(), up.column() - 1));
        }
        map[up.row()][up.column()] = map[position.row()][position.column()];
        map[position.row()][position.column()] = ' ';
    }

    private void moveRobotRight() {
        for (Position position = new Position(robot.row(), robot.column() + 1); map[position.row()][position.column()] != '#'; position = new Position(position.row(), position.column() + 1)) {
            if (map[position.row()][position.column()] == ' ') {
                slideRightUntil(position);
                return;
            }
        }
    }

    private void slideRightUntil(Position position) {
        map[robot.row()][robot.column()] = ' ';
        this.robot = new Position(robot.row(), robot.column() + 1);
        map[robot.row()][robot.column()] = '@';
        for (int column = robot.column() + 1; column <= position.column(); column += 2) {
            map[robot.row()][column] = '[';
            map[robot.row()][column + 1] = ']';
        }
    }

    private void moveRobotDown() {
        if (freeSpaceDownOf(robot)) {
            moveDown(robot);
            robot = new Position(robot.row() + 1, robot.column());
        }
    }

    private boolean freeSpaceDownOf(Position position) {
        Position down = new Position(position.row() + 1, position.column());
        if (map[down.row()][down.column()] == '#') {
            return false;
        }
        if (map[down.row()][down.column()] == '[') {
            return freeSpaceDownOf(down) && freeSpaceDownOf(new Position(down.row(), down.column() + 1));
        }
        if (map[down.row()][down.column()] == ']') {
            return freeSpaceDownOf(down) && freeSpaceDownOf(new Position(down.row(), down.column() - 1));
        }
        return true;
    }

    private void moveDown(Position position) {
        Position down = new Position(position.row() + 1, position.column());
        if (map[down.row()][down.column()] == '[') {
            moveDown(down);
            moveDown(new Position(down.row(), down.column() + 1));
        }
        if (map[down.row()][down.column()] == ']') {
            moveDown(down);
            moveDown(new Position(down.row(), down.column() - 1));
        }
        map[down.row()][down.column()] = map[position.row()][position.column()];
        map[position.row()][position.column()] = ' ';
    }

    private void moveRobotLeft() {
        for (Position position = new Position(robot.row(), robot.column() - 1); map[position.row()][position.column()] != '#'; position = new Position(position.row(), position.column() - 1)) {
            if (map[position.row()][position.column()] == ' ') {
                slideLeftUntil(position);
                return;
            }
        }
    }

    private void slideLeftUntil(Position position) {
        map[robot.row()][robot.column()] = ' ';
        this.robot = new Position(robot.row(), robot.column() - 1);
        map[robot.row()][robot.column()] = '@';
        for (int column = robot.column() - 1; column >= position.column(); column -= 2) {
            map[robot.row()][column] = ']';
            map[robot.row()][column - 1] = '[';
        }
    }

    public long sumOfBoxesGPS() {
        long sum = 0;
        for (int row = 0; row < map.length; row++) {
            for (int column = 0; column < map[0].length; column++) {
                if (map[row][column] == '[') {
                    sum += 100L * row + column;
                }
            }
        }
        return sum;
    }

    void show() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : map) {
            for (int column = 0; column < map[0].length; column++) {
                sb.append(row[column]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
