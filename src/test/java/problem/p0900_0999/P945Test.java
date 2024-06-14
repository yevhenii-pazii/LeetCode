package problem.p0900_0999;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P945Test {

    private final P945 p945 = new P945();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[]{1, 2, 2}, 1),
            arguments(new int[]{3, 2, 1, 2, 1, 7}, 6)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void minIncrementForUnique(int[] nums, int result) {
        assertThat(p945.minIncrementForUnique(nums)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void minIncrementForUniqueSorting(int[] nums, int result) {
        assertThat(p945.minIncrementForUniqueSorting(nums)).isEqualTo(result);
    }

}
