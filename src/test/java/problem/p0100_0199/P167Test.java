package problem.p0100_0199;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P167Test {

    private P167 p167 = new P167();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
                arguments(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
                arguments(new int[]{-1, 0}, -1, new int[]{1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void twoSumTwoPointers(int[] numbers, int target, int[] expected) {
        assertThat(p167.twoSumTwoPointers(numbers, target)).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void twoSumBinarySearch(int[] numbers, int target, int[] expected) {
        assertThat(p167.twoSumBinarySearch(numbers, target)).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void twoSumBinarySearch2(int[] numbers, int target, int[] expected) {
        assertThat(p167.twoSumBinarySearch2(numbers, target)).containsExactly(expected);
    }
}
