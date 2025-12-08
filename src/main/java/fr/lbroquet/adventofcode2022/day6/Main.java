package fr.lbroquet.adventofcode2022.day6;

import fr.lbroquet.Input;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {
    public static void main() throws IOException {
        try (BufferedReader reader = Input.load(Main.class)) {
            String stream = reader.readLine();

            Protocol protocol = new Protocol(stream);

            IO.println(protocol.startOfPacket());
            IO.println(protocol.startOfMessage());
        }

    }
}
