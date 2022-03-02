package katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Kata8Test {
    @Test
    public void testExecute() {
        assertThat(Kata8.execute()).hasSize(4);
    }
}
