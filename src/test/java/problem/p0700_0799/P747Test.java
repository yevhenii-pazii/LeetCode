package problem.p0700_0799;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P747Test {

    private final P747 p747 = new P747();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{3, 6, 1, 0}, 1),
                arguments(new int[]{1, 2, 3, 4}, -1),
                arguments(new int[]{0, 0, 0, 1}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void dominantIndex(int[] nums, int expected) {
        assertThat(p747.dominantIndex(nums)).isEqualTo(expected);
    }
}
