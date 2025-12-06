package fr.lbroquet.adventofcode2025.day2;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.stream.Stream;

public class Main {
    static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            long totalInvalidIds = Stream.of(reader.readLine().split(","))
                    .map(Main::toRange)
                    .map(Range::invalidIds)
                    .mapToLong(Main::sum)
                    .sum();
            System.out.println("Total invalid IDs: " + totalInvalidIds);
        }
    }

    private static long sum(Collection<Long> longs) {
        return Stream.of(longs.toArray(new Long[0])).mapToLong(Long::longValue).sum();
    }

    private static Range toRange(String rangeAsString) {
        String[] ids = rangeAsString.split("-");
        return new Range(ids[0], ids[1]);
    }
}
