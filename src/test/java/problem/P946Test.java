package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P946Test {

    private final P946 p946 = new P946();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}, true),
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}, false),
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}, true),
                arguments(new int[]{0, 2, 1}, new int[]{0, 1, 2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void validateStackSequencesStack(int[] pushed, int[] popped, boolean expected) {
        assertThat(p946.validateStackSequencesStack(pushed, popped)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void validateStackSequencesArrayStack(int[] pushed, int[] popped, boolean expected) {
        assertThat(p946.validateStackSequencesArrayStack(pushed, popped)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void validateStackSequences(int[] pushed, int[] popped, boolean expected) {
        assertThat(p946.validateStackSequences(pushed, popped)).isEqualTo(expected);
    }
}
