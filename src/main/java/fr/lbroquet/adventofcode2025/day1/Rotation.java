package fr.lbroquet.adventofcode2025.day1;

public sealed interface Rotation {
    int move(Pointer pointer);

    record Add(int distance) implements Rotation {
        @Override
        public int move(Pointer pointer) {
            return pointer.add(distance);
        }
    }
    record Sub(int distance) implements Rotation {
        @Override
        public int move(Pointer pointer) {
            return pointer.sub(distance);
        }
    }
}
