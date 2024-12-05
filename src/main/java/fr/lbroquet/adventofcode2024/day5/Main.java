package fr.lbroquet.adventofcode2024.day5;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        Collection<String> rules = new ArrayList<>();
        Collection<String[]> updates = new ArrayList<>();
        try (BufferedReader reader = Input.load(Main.class)) {
            for (String line; !(line = reader.readLine()).isEmpty(); ) {
                rules.add(line);
            }

            for (String line; (line = reader.readLine()) != null; ) {
                updates.add(line.split(","));
            }
        }

        PageComparator pageComparator = new PageComparator(rules);
        int sumOrdered = updates
                .stream()
                .filter(pageComparator::ordered)
                .mapToInt(Main::middlePage)
                .sum();
        System.out.println("Sum of ordered middle pages: " + sumOrdered);

        int sumInitiallyUnordered = updates
                .stream()
                .filter(update -> !pageComparator.ordered(update))
                .map(update -> sort(update, pageComparator))
                .mapToInt(Main::middlePage)
                .sum();
        System.out.println("Sum of unordered middle pages after ordering: " + sumInitiallyUnordered);
    }

    private static String[] sort(String[] update, Comparator<String> pageComparator) {
        Arrays.sort(update, pageComparator);
        return update;
    }

    private static int middlePage(String[] update) {
        return Integer.parseInt(update[update.length / 2]);
    }
}
