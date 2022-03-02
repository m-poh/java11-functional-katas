package katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Kata5Test {
    @Test
    public void testExecute() {
        assertThat(Kata5.execute()).isEqualTo(4);
    }
}
