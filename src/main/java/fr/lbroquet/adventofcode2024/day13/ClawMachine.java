package fr.lbroquet.adventofcode2024.day13;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Long.parseLong;

class ClawMachine {
    private static final Pattern BUTTON_A = java.util.regex.Pattern.compile("Button A: X\\+(?<deltaX>\\d+), Y\\+(?<deltaY>\\d+)");
    private static final Pattern BUTTON_B = java.util.regex.Pattern.compile("Button B: X\\+(?<deltaX>\\d+), Y\\+(?<deltaY>\\d+)");
    private static final Pattern PRIZE = java.util.regex.Pattern.compile("Prize: X=(?<prizeX>\\d+), Y=(?<prizeY>\\d+)");
    private final Vector p;
    private final Matrix base;
    private Vector pushes;

    public ClawMachine(String buttonA, String buttonB, String prize) {
        Vector a = vectorA(buttonA);
        Vector b = vectorB(buttonB);
        p = vectorP(prize);
        base = new Matrix(a, b);
        if (base.invertible()) {
            pushes = base.inverse().multiply(p);
        }
    }

    private static Vector vectorA(String buttonA) {
        Matcher matcherA = BUTTON_A.matcher(buttonA);
        if (matcherA.matches()) {
            Ratio deltaXA = Ratio.of(parseLong(matcherA.group("deltaX")));
            Ratio deltaYA = Ratio.of(parseLong(matcherA.group("deltaY")));
            return new Vector(deltaXA, deltaYA);
        }
        throw new IllegalArgumentException(buttonA);
    }

    private static Vector vectorB(String buttonB) {
        Matcher matcherB = BUTTON_B.matcher(buttonB);
        if (matcherB.matches()) {
            Ratio deltaXB = Ratio.of(parseLong(matcherB.group("deltaX")));
            Ratio deltaYB = Ratio.of(parseLong(matcherB.group("deltaY")));
            return new Vector(deltaXB, deltaYB);
        }
        throw new IllegalArgumentException(buttonB);
    }

    private static Vector vectorP(String prize) {
        Matcher matcherPrize = PRIZE.matcher(prize);
        if (matcherPrize.matches()) {
            Ratio prizeX = Ratio.of(parseLong(matcherPrize.group("prizeX")));
            Ratio prizeY = Ratio.of(parseLong(matcherPrize.group("prizeY")));
            return new Vector(prizeX.add(Ratio.of(10000000000000L)), prizeY.add(Ratio.of(10000000000000L)));
        }
        throw new IllegalArgumentException(prize);
    }

    public boolean winnable() {
        return base.invertible() && base.inverse().multiply(p).isInteger();
    }

    public long fewestToken() {
        return pushes.x().multiply(Ratio.of(3)).add(pushes.y()).numerator();
    }
}
