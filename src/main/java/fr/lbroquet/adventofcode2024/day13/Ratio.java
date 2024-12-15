package fr.lbroquet.adventofcode2024.day13;

import static java.lang.Math.*;

public record Ratio(long numerator, long denominator) {

    public static Ratio of(long numerator) {
        return of(numerator, 1);
    }

    public static Ratio of(long numerator, long denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("denominator cannot be zero");
        }
        long greatestCommonDenominator = gcd(numerator, denominator);
        return new Ratio(numerator / greatestCommonDenominator, denominator / greatestCommonDenominator);
    }

    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public Ratio negate() {
        return Ratio.of(negateExact(numerator), denominator);
    }

    public Ratio add(Ratio other) {
        return Ratio.of(addExact(multiplyExact(numerator, other.denominator), multiplyExact(other.numerator, denominator)), multiplyExact(denominator, other.denominator));
    }

    public Ratio subtract(Ratio other) {
        return Ratio.of(subtractExact(multiplyExact(numerator, other.denominator), multiplyExact(other.numerator, denominator)), multiplyExact(denominator, other.denominator));
    }

    public Ratio multiply(Ratio other) {
        return Ratio.of(multiplyExact(numerator, other.numerator), multiplyExact(denominator, other.denominator));
    }

    public Ratio divide(Ratio other) {
        return Ratio.of(multiplyExact(numerator, other.denominator), multiplyExact(denominator, other.numerator));
    }

    public boolean isNotZero() {
        return numerator != 0;
    }

    public boolean isInteger() {
        return numerator % denominator == 0;
    }
}
