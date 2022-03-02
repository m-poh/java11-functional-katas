package katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Kata3Test {
    @Test
    public void testExecute() {
        assertThat(Kata3.execute()).hasSize(4);
    }
}
