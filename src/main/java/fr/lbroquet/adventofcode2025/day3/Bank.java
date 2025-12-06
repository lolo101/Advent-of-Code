package fr.lbroquet.adventofcode2025.day3;

record Bank(String batteries) {
    public long outputJoltage(int quantityOfBatteries) {
        StringBuilder sb = new StringBuilder(quantityOfBatteries);
        for (int leftIndex = 0, rightIndex = batteries.length() - quantityOfBatteries + 1;
        rightIndex <= batteries.length();
        ++rightIndex) {
            int leftmostHigherJoltage = indexOfLeftmostHigherJoltage(batteries.substring(leftIndex, rightIndex));
            sb.append(batteries.charAt(leftIndex + leftmostHigherJoltage));
            leftIndex += leftmostHigherJoltage + 1;
        }
        return Long.parseLong(sb.toString());
    }

    private static int indexOfLeftmostHigherJoltage(String subBank) {
        int maxChar = subBank.chars().max().orElse(0);
        return subBank.indexOf(maxChar);
    }
}
