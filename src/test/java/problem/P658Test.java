package problem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P658Test {

    private final P658 p658 = new P658();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, 4, 3, new Integer[]{1, 2, 3, 4}),
                arguments(new int[]{1, 2, 3, 4, 5}, 4, -1, new Integer[]{1, 2, 3, 4}),
                arguments(new int[]{1, 2, 4, 5}, 2, 3, new Integer[]{2, 4}),
                arguments(new int[]{1, 1, 1, 10, 10, 10}, 1, 9, new Integer[]{10}),
                arguments(new int[]{0, 1, 1, 1, 2, 3, 6, 7, 8, 9}, 9, 4, new Integer[]{0, 1, 1, 1, 2, 3, 6, 7, 8})
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void findClosestElements(int[] arr, int k, int x, Integer[] expected) {
        assertThat(p658.findClosestElements(arr, k, x)).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findClosestElementsBinarySearch(int[] arr, int k, int x, Integer[] expected) {
        assertThat(p658.findClosestElementsBinarySearch(arr, k, x)).containsExactly(expected);
    }
}
