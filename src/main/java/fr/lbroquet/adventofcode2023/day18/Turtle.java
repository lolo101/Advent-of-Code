package fr.lbroquet.adventofcode2023.day18;

public class Turtle {
    public int row;
    public int column;

//    private int top;
//    private int right;
//    private int left;
//    private int bottom;

//    public void process(Iterable<DigStep> digSteps) {
//        for (DigStep step : digSteps) {
//            move(step);
//            adjustBoundaries();
//        }
//    }

    public void move(DigStep step) {
        switch (step.direction()) {
            case Up -> row += step.length();
            case Right -> column += step.length();
            case Down -> row -= step.length();
            case Left -> column -= step.length();
        }
    }

//    private void adjustBoundaries() {
//        top = max(top, row);
//        right = max(right, column);
//        bottom = min(bottom, row);
//        left = min(left, column);
//    }
}
