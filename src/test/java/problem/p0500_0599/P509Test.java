package problem.p0500_0599;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P509Test {

    private final P509 p509 = new P509();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(0, 0),
                arguments(1, 1),
                arguments(2, 1),
                arguments(3, 2),
                arguments(4, 3),
                arguments(30, 832040)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void fib(int input, int expected) {
        assertThat(p509.fib(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void fibFlat(int input, int expected) {
        assertThat(p509.fibFlat(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void fibRecursionWithMemorization(int input, int expected) {
        assertThat(p509.fibRecursionWithMemorization(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void fibGoldenRatio(int input, int expected) {
        assertThat(p509.fibGoldenRatio(input)).isEqualTo(expected);
    }

}
