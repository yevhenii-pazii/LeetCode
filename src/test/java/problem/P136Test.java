package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P136Test {

    private final P136 p136 = new P136();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{2, 2, 1}, 1),
                arguments(new int[]{4, 1, 2, 1, 2}, 4),
                arguments(new int[]{4}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void singleNumberBruteForce(int[] nums, int expected) {
        assertThat(p136.singleNumberBruteForce(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void singleNumberSet(int[] nums, int expected) {
        assertThat(p136.singleNumberSet(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void singleNumberSorting(int[] nums, int expected) {
        assertThat(p136.singleNumberSorting(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void singleNumberXor(int[] nums, int expected) {
        assertThat(p136.singleNumberXor(nums)).isEqualTo(expected);
    }
}
