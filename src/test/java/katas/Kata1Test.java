package katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Kata1Test {
    @Test
    public void testExecute() {
        assertThat(Kata1.execute()).hasSize(4);
    }
}
