package problem.p0500_0599;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P523Test {

    private final P523 p523 = new P523();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[]{23, 2, 4, 6, 7}, 6, true),
            arguments(new int[]{23, 2, 6, 4, 7}, 6, true),
            arguments(new int[]{23, 2, 6, 4, 7}, 13, false),
            arguments(new int[]{0}, 1, false),
            arguments(new int[]{5, 0, 0, 0}, 3, true)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void checkSubarraySum(int[] nums, int k, boolean result) {
        assertThat(p523.checkSubarraySum(nums, k)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void checkSubarraySumV1(int[] nums, int k, boolean result) {
        assertThat(p523.checkSubarraySumV1(nums, k)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void checkSubarraySumModPrefix(int[] nums, int k, boolean result) {
        assertThat(p523.checkSubarraySumModPrefix(nums, k)).isEqualTo(result);
    }

}
