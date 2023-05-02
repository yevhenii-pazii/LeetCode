package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P189Test {

    private final P189 p189 = new P189();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
                arguments(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void rotateAdditionalArray(int[] nums, int k, int[] expected) {
        p189.rotateAdditionalArray(nums, k);
        assertThat(nums).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void rotateKRotations(int[] nums, int k, int[] expected) {
        p189.rotateKRotations(nums, k);
        assertThat(nums).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void rotateFlow(int[] nums, int k, int[] expected) {
        p189.rotateFlow(nums, k);
        assertThat(nums).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void rotateReverse(int[] nums, int k, int[] expected) {
        p189.rotateReverse(nums, k);
        assertThat(nums).isEqualTo(expected);
    }
}
