package fr.lbroquet.adventofcode2025.day1;

public sealed interface Rotation {
    void move(Pointer pointer);

    record Add(int distance) implements Rotation {
        @Override
        public void move(Pointer pointer) {
            pointer.add(distance);
        }
    }
    record Sub(int distance) implements Rotation {
        @Override
        public void move(Pointer pointer) {
            pointer.sub(distance);
        }
    }
}
