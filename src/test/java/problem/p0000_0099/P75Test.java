package problem.p0000_0099;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P75Test {

    private final P75 p75 = new P75();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[]{2, 0, 2, 1, 1, 0}, new int[]{0, 0, 1, 1, 2, 2}),
            arguments(new int[]{2, 0, 1}, new int[]{0, 1, 2}),
            arguments(new int[]{0}, new int[]{0}),
            arguments(new int[]{2, 0}, new int[]{0, 2})
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void sortColors(int[] nums, int[] result) {
        p75.sortColors(nums);
        assertThat(nums).containsExactly(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void sortColorsInPlace(int[] nums, int[] result) {
        p75.sortColorsInPlace(nums);
        assertThat(nums).containsExactly(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void sortColorsCounting(int[] nums, int[] result) {
        p75.sortColorsCounting(nums);
        assertThat(nums).containsExactly(result);
    }

}
