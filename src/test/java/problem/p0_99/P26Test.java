package problem.p0_99;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P26Test {

    private final P26 p26 = new P26();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 1, 1, 2, 2, 3}, 3, new int[]{1, 2, 3}),
                arguments(new int[]{1, 5, 7}, 3, new int[]{1, 5, 7})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeDuplicates(int[] nums, int expectedLength, int[] expectedArray) {
        assertThat(p26.removeDuplicates(nums)).isEqualTo(expectedLength);
        assertThat(Arrays.copyOf(nums, expectedLength)).isEqualTo(expectedArray);
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeDuplicatesV2(int[] nums, int expectedLength, int[] expectedArray) {
        assertThat(p26.removeDuplicatesV2(nums)).isEqualTo(expectedLength);
        assertThat(Arrays.copyOf(nums, expectedLength)).isEqualTo(expectedArray);
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeDuplicatesTwoPointers(int[] nums, int expectedLength, int[] expectedArray) {
        assertThat(p26.removeDuplicatesTwoPointers(nums)).isEqualTo(expectedLength);
        assertThat(Arrays.copyOf(nums, expectedLength)).isEqualTo(expectedArray);
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeDuplicatesCounting(int[] nums, int expectedLength, int[] expectedArray) {
        assertThat(p26.removeDuplicatesCounting(nums)).isEqualTo(expectedLength);
        assertThat(Arrays.copyOf(nums, expectedLength)).isEqualTo(expectedArray);
    }
}
