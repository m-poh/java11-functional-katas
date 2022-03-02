package katas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Kata4Test {
    @Test
    public void testExecute() {
        assertThat(Kata4.execute()).hasSize(4);
    }
}
