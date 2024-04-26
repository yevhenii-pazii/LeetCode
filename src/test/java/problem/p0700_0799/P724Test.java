package problem.p0700_0799;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P724Test {

    private final P724 p724 = new P724();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 7, 3, 6, 5, 6}, 3),
                arguments(new int[]{2, 1, -1}, 0),
                arguments(new int[]{-1, 1, 2}, 2),
                arguments(new int[]{1, 2, 3}, -1)
        );//.skip(3);
    }

    @ParameterizedTest
    @MethodSource("data")
    void pivotIndexOfficial(int[] nums, int expected) {
        assertThat(p724.pivotIndexOfficial(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void pivotIndex(int[] nums, int expected) {
        assertThat(p724.pivotIndex(nums)).isEqualTo(expected);
    }
}
