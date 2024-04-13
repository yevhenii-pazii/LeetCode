package problem.p0400_0499;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P494Test {

    private final P494 p494 = new P494();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 1, 1, 1, 1}, 3, 5),
                arguments(new int[]{1}, 1, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void findTargetSumWaysQueue(int[] nums, int target, int expected) {
        assertThat(p494.findTargetSumWaysQueue(nums, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findTargetSumWaysRecursion(int[] nums, int target, int expected) {
        assertThat(p494.findTargetSumWaysRecursion(nums, target)).isEqualTo(expected);
    }
}
