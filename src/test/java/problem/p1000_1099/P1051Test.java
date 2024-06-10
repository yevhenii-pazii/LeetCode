package problem.p1000_1099;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1051Test {

    private final P1051 p1051 = new P1051();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[]{1, 1, 4, 2, 1, 3}, 3),
            arguments(new int[]{5, 1, 2, 3, 4}, 5),
            arguments(new int[]{1, 2, 3, 4, 5}, 0)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void heightChecker(int[] heights, int result) {
        assertThat(p1051.heightChecker(heights)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void heightCheckerArraySort(int[] heights, int result) {
        assertThat(p1051.heightCheckerArraySort(heights)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void heightCheckerCounting(int[] heights, int result) {
        assertThat(p1051.heightCheckerCounting(heights)).isEqualTo(result);
    }
}
