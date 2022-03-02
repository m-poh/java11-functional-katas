package katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Kata9Test {
    @Test
    public void testExecute() {
        assertThat(Kata9.execute()).hasSize(4);
    }
}
