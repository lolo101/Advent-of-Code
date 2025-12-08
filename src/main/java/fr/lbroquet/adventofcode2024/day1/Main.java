package fr.lbroquet.adventofcode2024.day1;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.Collections.sort;

public class Main {

    private static final Pattern SEPARATOR = Pattern.compile("\\s+");
    private static final List<Integer> leftList = new ArrayList<>();
    private static final List<Integer> rightList = new ArrayList<>();

    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            reader.lines().map(SEPARATOR::split).forEach(Main::collectIds);
        }
        sort(leftList);
        sort(rightList);
        long totalDistance = totalDistance(new ArrayList<>(leftList), new ArrayList<>(rightList));
        long similarity = similarity(new ArrayList<>(leftList), new ArrayList<>(rightList));
        IO.println("total distance: " + totalDistance);
        IO.println("similarity: " + similarity);
    }

    private static void collectIds(String[] ids) {
        int leftId = Integer.parseInt(ids[0]);
        int rightId = Integer.parseInt(ids[1]);
        leftList.add(leftId);
        rightList.add(rightId);
    }

    private static long totalDistance(List<Integer> leftList, List<Integer> rightList) {
        long totalDistance = 0;
        while (!leftList.isEmpty()) {
            int leftId = leftList.removeFirst();
            int rightId = rightList.removeFirst();
            int distance = Math.abs(leftId - rightId);
            totalDistance += distance;
        }
        return totalDistance;
    }

    private static long similarity(List<Integer> leftList, List<Integer> rightList) {
        long similarity = 0;
        while (!leftList.isEmpty()) {
            int leftId = leftList.removeFirst();
            long duplicationsInRightList = duplications(leftId, rightList);
            similarity += (long) leftId * duplicationsInRightList;
        }
        return similarity;
    }

    private static long duplications(int id, List<Integer> list) {
        while (!list.isEmpty() && list.getFirst() < id) {
            list.removeFirst();
        }
        long duplicatesInRightList = 0;
        while (!list.isEmpty() && list.getFirst() == id) {
            duplicatesInRightList++;
            list.removeFirst();
        }
        return duplicatesInRightList;
    }
}
