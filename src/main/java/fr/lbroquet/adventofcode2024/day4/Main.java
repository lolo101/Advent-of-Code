package fr.lbroquet.adventofcode2024.day4;

import fr.lbroquet.Input;

public class Main {
    public static void main(String[] args) {
        char[][] array = Input.load(Main.class).lines().map(String::toCharArray).toArray(char[][]::new);
        WordSearch wordSearch = new WordSearch(array);
        System.out.println(wordSearch.count());
    }
}
