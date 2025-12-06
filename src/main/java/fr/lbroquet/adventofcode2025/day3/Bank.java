package fr.lbroquet.adventofcode2025.day3;

record Bank(String batteries) {
    public long largestJoltage() {
        int leftmostHigherJoltage = indexOfLeftmostHigherJoltage(batteries.substring(0, batteries.length() - 1));
        int rightHigherJoltage = indexOfLeftmostHigherJoltage(batteries.substring(leftmostHigherJoltage + 1));
        return Long.parseLong("%c%c".formatted(
                batteries.charAt(leftmostHigherJoltage),
                batteries.charAt(leftmostHigherJoltage + rightHigherJoltage + 1)
        ));
    }

    private static int indexOfLeftmostHigherJoltage(String subBank) {
        int maxChar = subBank.chars().max().orElse(0);
        return subBank.indexOf(maxChar);
    }
}
