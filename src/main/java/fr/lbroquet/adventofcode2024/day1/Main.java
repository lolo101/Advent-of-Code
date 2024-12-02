package fr.lbroquet.adventofcode2024.day1;

import fr.lbroquet.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.Collections.sort;

public class Main {

    private static final Pattern SEPARATOR = Pattern.compile("\\s+");
    private static final List<Integer> leftList = new ArrayList<>();
    private static final List<Integer> rightList = new ArrayList<>();

    public static void main(String[] args) {
        Input.load(Main.class).lines().map(SEPARATOR::split).forEach(Main::collectIds);
        sort(leftList);
        sort(rightList);
        long totalDistance = 0;
        while (!leftList.isEmpty()) {
            int leftId = leftList.removeFirst();
            int rightId = rightList.removeFirst();
            int distance = Math.abs(leftId - rightId);
            totalDistance += distance;
        }
        System.out.println("total distance: " + totalDistance);
    }

    private static void collectIds(String[] ids) {
        int leftId = Integer.parseInt(ids[0]);
        int rightId = Integer.parseInt(ids[1]);
        leftList.add(leftId);
        rightList.add(rightId);
    }
}
