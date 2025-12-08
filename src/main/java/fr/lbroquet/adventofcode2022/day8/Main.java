package fr.lbroquet.adventofcode2022.day8;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            Forest forest = reader.lines()
                    .map(Main::toTrees)
                    .collect(
                            Forest::new,
                            Forest::add,
                            Forest::merge);

            IO.println(forest.countVisibleTrees());
            IO.println(forest.highestScenicScore());
            IO.println(forest.printVisibleTrees());
        }
    }

    private static Tree[] toTrees(String line) {
        return line.chars()
                .map(ch -> ch - '0')
                .mapToObj(Tree::new)
                .toArray(Tree[]::new);
    }
}
