package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P2870Test {

    private final P2870 p2870 = new P2870();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}, 4),
                arguments(new int[]{2, 1, 2, 2, 3, 3}, -1),
                arguments(new int[]{14,12,14,14,12,14,14,12,12,12,12,14,14,12,14,14,14,12,12}, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void minOperationsRecursion(int[] nums, int result) {
        assertThat(p2870.minOperationsRecursion(nums)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void minOperationsMemo(int[] nums, int result) {
        assertThat(p2870.minOperationsMemo(nums)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void minOperationsMemoV2(int[] nums, int result) {
        assertThat(p2870.minOperationsMemoV2(nums)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void minOperationsMath(int[] nums, int result) {
        assertThat(p2870.minOperationsMath(nums)).isEqualTo(result);
    }
}
