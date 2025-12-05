package fr.lbroquet.adventofcode2025.day1;

public sealed interface Rotation {
    int move(Dial dial);

    record Add(int distance) implements Rotation {
        @Override
        public int move(Dial dial) {
            return dial.add(distance);
        }
    }
    record Sub(int distance) implements Rotation {
        @Override
        public int move(Dial dial) {
            return dial.sub(distance);
        }
    }
}
