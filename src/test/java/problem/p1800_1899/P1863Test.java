package problem.p1800_1899;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1863Test {

    private final P1863 p1863 = new P1863();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[]{1, 3}, 6),
            arguments(new int[]{5, 1, 6}, 28),
            arguments(new int[]{3, 4, 5, 6, 7, 8}, 480)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void subsetXORSum(int[] nums, int result) {
        assertThat(p1863.subsetXORSum(nums)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void subsetXORSumBacktracking(int[] nums, int result) {
        assertThat(p1863.subsetXORSumBacktracking(nums)).isEqualTo(result);
    }

}
