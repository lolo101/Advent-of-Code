package fr.lbroquet.adventofcode2025.day2;

import java.util.ArrayList;
import java.util.List;

public record Range(String firstId, String lastId) {
    /**
     * Invalid IDs are defined as number with an even number of digits, where both halves are identical.
     * E.g. 11, 1212, 123123, 4444 are invalid.
     * @return the quantity of invalid number in this range.
     */
    public List<Long> invalidIds() {
        long firstIdInclusive = Long.parseLong(firstId);
        long lastIdInclusive = Long.parseLong(lastId);
        String halfDigits = halfDigits(firstId);

        List<Long> result = new ArrayList<>();
        for(
                long invalidId;
                (invalidId = Long.parseLong(halfDigits + halfDigits)) <= lastIdInclusive;
                halfDigits = Long.toString(Long.parseLong(halfDigits) + 1)) {
            if (firstIdInclusive <= invalidId) {
                result.add(invalidId);
            }
        }
        return result;
    }

    private static String halfDigits(String id) {
        int length = id.length();
        if (length % 2 == 0) {
            return id.substring(0, length / 2);
        } else {
            int halfLength = length / 2;
            long halfValue = Math.powExact(10L, halfLength);
            return Long.toString(halfValue);
        }
    }
}
