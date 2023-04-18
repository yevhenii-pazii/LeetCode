package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P66Test {

    private final P66 p66 = new P66();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                arguments(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
                arguments(new int[]{9}, new int[]{1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void plusOneEdgeCase(int[] digits, int[] expected) {
        assertThat(p66.plusOneEdgeCase(digits)).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void plusOneBaseCaseOptimized(int[] digits, int[] expected) {
        assertThat(p66.plusOneBaseCaseOptimized(digits)).containsExactly(expected);
    }
}
