package fr.lbroquet.adventofcode2025.day2;

import java.util.HashSet;
import java.util.Set;

public record Range(String firstId, String lastId) {
    /**
     * Invalid IDs are defined as number with an even number of digits, where both halves are identical.
     * E.g. 11, 1212, 123123, 4444 are invalid.
     * @return the quantity of invalid number in this range.
     */
    public Set<Long> invalidIds() {
        Set<Long> result = new HashSet<>();
        long firstIdInclusive = Long.parseLong(firstId);
        long lastIdInclusive = Long.parseLong(lastId);
        int lastIdLength = lastId.length();
        for (
                int repeats = 2;
                repeats <= lastIdLength;
                ++repeats
        ) {
            String repeatedDigits = repeatedDigits(firstId, repeats);
            for(
                    long invalidId;
                    (invalidId = fullInvalidId(repeatedDigits, repeats)) <= lastIdInclusive;
                    repeatedDigits = Long.toString(Long.parseLong(repeatedDigits) + 1)) {
                if (firstIdInclusive <= invalidId && invalidId <= lastIdInclusive) {
                    result.add(invalidId);
                }
            }
        }
        return result;
    }

    private static long fullInvalidId(String repeatedDigits, int repeats) {
        return Long.parseLong(repeatedDigits.repeat(repeats));
    }

    private static String repeatedDigits(String id, int repeats) {
        int length = id.length();
        if (length % repeats == 0) {
            return id.substring(0, length / repeats);
        } else {
            int repeatedLength = length / repeats;
            long repeatedValue = Math.powExact(10L, repeatedLength);
            return Long.toString(repeatedValue);
        }
    }
}
