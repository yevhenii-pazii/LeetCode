package problem.p200_299;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P287Test {

    private final P287 p287 = new P287();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 3, 4, 2, 2}, 2),
                arguments(new int[]{3, 1, 3, 4, 2}, 3),
                arguments(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}, 9),
                arguments(new int[]{13, 46, 8, 11, 20, 17, 40, 13, 13, 13, 14, 1, 13, 36, 48, 41, 13, 13, 13, 13, 45, 13, 28, 42, 13, 10, 15, 22, 13, 13, 13, 13, 23, 9, 6, 13, 47, 49, 16, 13, 13, 39, 35, 13, 32, 29, 13, 25, 30, 13}, 13)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void findDuplicate(int[] nums, int expected) {
        assertThat(p287.findDuplicate(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findDuplicateCounting(int[] nums, int expected) {
        assertThat(p287.findDuplicateCounting(nums)).isEqualTo(expected);
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void findDuplicateBits(int[] nums, int expected) {
        assertThat(p287.findDuplicateBits(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findDuplicateSet(int[] nums, int expected) {
        assertThat(p287.findDuplicateSet(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findDuplicateCyclicSort(int[] nums, int expected) {
        assertThat(p287.findDuplicateCyclicSort(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findDuplicateFastSlow(int[] nums, int expected) {
        assertThat(p287.findDuplicateFastSlow(nums)).isEqualTo(expected);
    }
}
