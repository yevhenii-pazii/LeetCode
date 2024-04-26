package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class P374Test {

    //private final P374 p374 = new P374();

    @ParameterizedTest
    @ValueSource(ints = {1, Integer.MAX_VALUE, 50, 1_000_000})
    void guessNumber(int n) {
        assertThat(new P374.Solution(n).guessNumber(Integer.MAX_VALUE)).isEqualTo(n);
    }

}
