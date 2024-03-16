package problem.p0_99;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P27Test {

    private final P27 p27 = new P27();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{3, 2, 2, 3}, 3, new int[]{2, 2}, 2),
                arguments(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, new int[]{0, 0, 1, 3, 4}, 5)
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    void removeElement(int[] nums, int val, int[] expectedArray, int expectedLength) {
        assertThat(p27.removeElement(nums, val)).isEqualTo(expectedLength);
        assertThat(Arrays.copyOf(nums, expectedLength)).contains(expectedArray);
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeElementV2(int[] nums, int val, int[] expectedArray, int expectedLength) {
        assertThat(p27.removeElementV2(nums, val)).isEqualTo(expectedLength);
        assertThat(Arrays.copyOf(nums, expectedLength)).contains(expectedArray);
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeElementV3(int[] nums, int val, int[] expectedArray, int expectedLength) {
        assertThat(p27.removeElementV3(nums, val)).isEqualTo(expectedLength);
        assertThat(Arrays.copyOf(nums, expectedLength)).contains(expectedArray);
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeElementCopyFromBack(int[] nums, int val, int[] expectedArray, int expectedLength) {
        assertThat(p27.removeElementCopyFromBack(nums, val)).isEqualTo(expectedLength);
        assertThat(Arrays.copyOf(nums, expectedLength)).contains(expectedArray);
    }

}
