package katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Kata7Test {
    @Test
    public void testExecute() {
        assertThat(Kata7.execute()).hasSize(4);
    }
}
