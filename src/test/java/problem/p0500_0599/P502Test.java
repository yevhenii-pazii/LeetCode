package problem.p0500_0599;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P502Test {

    private final P502 p502 = new P502();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}, 4),
            arguments(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}, 6)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void findMaximizedCapital(int k, int w, int[] profits, int[] capital, int result) {
        assertThat(p502.findMaximizedCapital(k, w, profits, capital)).isEqualTo(result);
    }

}
