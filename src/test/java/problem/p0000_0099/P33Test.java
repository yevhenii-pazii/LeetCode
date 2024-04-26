package problem.p0000_0099;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P33Test {

    private final P33 p33 = new P33();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 0, 4),
                arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 3, -1),
                arguments(new int[]{1}, 0, -1),
                arguments(new int[]{3, 1}, 1, 1)
        ).skip(3);
    }

    @ParameterizedTest
    @MethodSource("data")
    void searchDoubleBinary(int[] nums, int target, int expected) {
        assertThat(p33.searchDoubleBinary(nums, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void searchSingleBinary(int[] nums, int target, int expected) {
        assertThat(p33.searchSingleBinary(nums, target)).isEqualTo(expected);
    }
}
