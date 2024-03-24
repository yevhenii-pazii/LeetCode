package problem.p0100_0199;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P154Test {

    private final P154 p154 = new P154();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 3, 5}, 1),
                arguments(new int[]{2, 2, 2, 0, 1}, 0),
                arguments(new int[]{2, 2, 2, 1, 2}, 1),
                arguments(new int[]{3, 3, 3, 1}, 1),
                arguments(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 1, 3}, 1),
                arguments(new int[]{1, 3, 3}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void findMinBinarySearch(int[] nums, int expected) {
        assertThat(p154.findMinBinarySearch(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findMinBinarySearch2(int[] nums, int expected) {
        assertThat(p154.findMinBinarySearch2(nums)).isEqualTo(expected);
    }
}
