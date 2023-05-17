package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P219Test {

    private final P219 p219 = new P219();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 1}, 3, true),
                arguments(new int[]{1, 0, 1, 1}, 1, true),
                arguments(new int[]{1, 2, 3, 1, 2, 3}, 2, false),
                arguments(new int[]{1, 2, 1}, 0, false)

        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void containsNearbyDuplicateSlidingWindow(int[] nums, int k, boolean expected) {
        assertThat(p219.containsNearbyDuplicateSlidingWindow(nums, k)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void containsNearbyDuplicateSlidingWindowWithSet(int[] nums, int k, boolean expected) {
        assertThat(p219.containsNearbyDuplicateSlidingWindowWithSet(nums, k)).isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("data")
    void containsNearbyDuplicateMap(int[] nums, int k, boolean expected) {
        assertThat(p219.containsNearbyDuplicateMap(nums, k)).isEqualTo(expected);
    }
}