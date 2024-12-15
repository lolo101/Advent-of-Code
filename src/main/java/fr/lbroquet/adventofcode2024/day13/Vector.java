package fr.lbroquet.adventofcode2024.day13;

record Vector(Ratio x, Ratio y) {

    public Vector divided(Ratio value) {
        return new Vector(x.divide(value), y.divide(value));
    }

    public boolean isInteger() {
        return x.isInteger() && y.isInteger();
    }
}
