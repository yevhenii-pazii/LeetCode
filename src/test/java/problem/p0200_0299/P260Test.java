package problem.p0200_0299;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P260Test {

    private final P260 p260 = new P260();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[]{1, 2, 1, 3, 2, 5}, new int[]{3, 5}),
            arguments(new int[]{-1, 0}, new int[]{-1, 0}),
            arguments(new int[]{1, 0}, new int[]{1, 0})
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void singleNumber(int[] nums, int[] result) {
        assertThat(p260.singleNumber(nums)).containsExactlyInAnyOrder(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void singleNumberHashSet(int[] nums, int[] result) {
        assertThat(p260.singleNumberHashSet(nums)).containsExactlyInAnyOrder(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void singleNumberBinary(int[] nums, int[] result) {
        assertThat(p260.singleNumberBinary(nums)).containsExactlyInAnyOrder(result);
    }
}
