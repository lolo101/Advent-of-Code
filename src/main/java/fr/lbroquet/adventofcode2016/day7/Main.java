package fr.lbroquet.adventofcode2016.day7;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            List<IPv7> ips = reader.lines().map(IPv7::new).toList();
            IO.println("Nb of IPv7 supporting TLS: " + ips.stream()
                    .filter(IPv7::doesSupportTransportLayerSnooping)
                    .count());
            IO.println("Nb of IPv7 supporting SSL: " + ips.stream()
                    .filter(IPv7::doesSupportSuperSecretListening)
                    .count());
        }
    }
}
