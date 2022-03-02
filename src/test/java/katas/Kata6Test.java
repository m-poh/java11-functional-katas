package katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Kata6Test {
    @Test
    public void testExecute() {
        assertThat(Kata6.execute()).isEqualTo("4");
    }
}
