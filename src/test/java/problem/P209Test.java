package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P209Test {

    private final P209 p209 = new P209();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(7, new int[]{2, 3, 1, 2, 4, 3}, 2),
                arguments(4, new int[]{1, 4, 4}, 1),
                arguments(7, new int[]{1, 1, 1, 1, 1, 1}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void minSubArrayLenTwoPointers(int target, int[] nums, int expected) {
        assertThat(p209.minSubArrayLenTwoPointers(target, nums)).isEqualTo(expected);
    }
}
