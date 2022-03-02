package katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Kata2Test {
    @Test
    public void testExecute() {
        assertThat(Kata2.execute()).hasSize(4);
    }
}
