package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P2439Test {

    private final P2439 p2439 = new P2439();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{3, 7, 1, 6}, 5),
                arguments(new int[]{10, 1}, 10),
                arguments(new int[]{13, 13, 20, 0, 8, 9, 9}, 16)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void minimizeArrayValueBruteForce(int[] nums, int expected) {
        assertThat(p2439.minimizeArrayValueBruteForce(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void minimizeArrayValue(int[] nums, int expected) {
        assertThat(p2439.minimizeArrayValue(nums)).isEqualTo(expected);
    }
}
