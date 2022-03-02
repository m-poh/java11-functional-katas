package katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Kata10Test {
    @Test
    public void testExecute() {
        assertThat(Kata10.execute()).hasSize(4);
    }
}
