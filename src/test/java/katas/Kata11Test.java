package katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Kata11Test {
    @Test
    public void testExecute() {
        assertThat(Kata11.execute()).hasSize(4);
    }
}
