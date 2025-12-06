package fr.lbroquet.adventofcode2023.day14;

import fr.lbroquet.Input;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main() throws IOException {
        char[][] platformArray = Input.loadMap(Main.class);
        Platform platform = new Platform(platformArray);
        List<Slider> sliders = platform.tilt();
        long load = sliders.stream().mapToLong(Slider::load).sum();
        System.out.printf("Total load: %d%n", load);
    }
}
