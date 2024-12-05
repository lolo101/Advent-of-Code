package fr.lbroquet.adventofcode2024.day5;

import java.util.*;

import static java.util.Collections.emptySortedSet;

public final class PageComparator implements Comparator<String> {
    private final Map<String, SortedSet<String>> smallerThan = new HashMap<>();
    private final Map<String, SortedSet<String>> biggerThan = new HashMap<>();

    public PageComparator(Iterable<String> rules) {
        for (String rule : rules) {
            String[] pair = rule.split("\\|");
            String smaller = pair[0];
            String bigger = pair[1];
            smallerThan.computeIfAbsent(smaller, _ -> new TreeSet<>()).add(bigger);
            biggerThan.computeIfAbsent(bigger, _ -> new TreeSet<>()).add(smaller);
        }
    }

    public boolean ordered(String[] update) {
        for (int pageIndex = 1; pageIndex < update.length; pageIndex++) {
            String currentPage = update[pageIndex - 1];
            String nextPage = update[pageIndex];
            if (compare(currentPage, nextPage) > 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int compare(String page1, String page2) {
        if (smallerThan.getOrDefault(page1, emptySortedSet()).contains(page2)) return -1;
        if (biggerThan.getOrDefault(page1, emptySortedSet()).contains(page2)) return 1;
        return 0;
    }
}
