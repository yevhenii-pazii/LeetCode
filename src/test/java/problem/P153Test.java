package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P153Test {

    private final P153 p153 = new P153();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{3, 4, 5, 1, 2}, 1),
                arguments(new int[]{4, 5, 6, 7, 0, 1, 2}, 0),
                arguments(new int[]{11, 13, 15, 17}, 11)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void findMin(int[] nums, int expected) {
        assertThat(p153.findMin(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findMinBinarySearch(int[] nums, int expected) {
        assertThat(p153.findMinBinarySearch(nums)).isEqualTo(expected);
    }
}
