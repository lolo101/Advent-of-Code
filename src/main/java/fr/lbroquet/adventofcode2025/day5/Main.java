package fr.lbroquet.adventofcode2025.day5;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            FreshIngredientRanges freshIngredientRanges = freshIngredientRanges(reader);
            long freshIngredientCount = reader.lines().mapToLong(Long::parseLong).filter(freshIngredientRanges::contains).count();
            System.out.println("Quantity of fresh ingredients: " + freshIngredientCount);
            System.out.println("Ingredients in ranges: " + freshIngredientRanges.size());
        }
    }

    private static FreshIngredientRanges freshIngredientRanges(BufferedReader reader) throws IOException {
        FreshIngredientRanges freshIngredientRanges = new FreshIngredientRanges();
        for (
                String line;
                !(line = reader.readLine()).isBlank();
        ) {
            String[] range = line.split("-");
            freshIngredientRanges.addRange(
                    Long.parseLong(range[0]),
                    Long.parseLong(range[1])
            );
        }
        return freshIngredientRanges;
    }
}
