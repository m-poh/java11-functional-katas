import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main(String[] args) {
        Main.preCheck();
    }

    static void preCheck() {
        assertEquals("Kata1 finished", "Kata1 finished");

        Stream.of("Kata 0")
                .map(message -> message + " solved!")
                .forEach(System.out::println);
    }
}
