package fr.lbroquet.adventofcode2016.day4;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final Pattern ROOM_TAG = Pattern.compile("(?<roomName>(?:\\p{Lower}+-)+)(?<sectorId>\\d+)\\[(?<checksum>\\p{Lower}{5})]");

    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            List<Room> rooms = reader.lines()
                    .map(ROOM_TAG::matcher)
                    .filter(Matcher::matches)
                    .map(Room::new)
                    .filter(Room::checksumMatching)
                    .toList();

            Optional<Integer> sectorSum = rooms.stream()
                    .map(Room::getSectorId)
                    .reduce(Integer::sum);
            IO.println(sectorSum.orElse(0));

            IO.println("--------");

            rooms.forEach(r -> IO.println(r.shiftName() + " -> " + r.getSectorId()));
        }
    }
}
