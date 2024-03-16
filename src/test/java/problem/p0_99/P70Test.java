package problem.p0_99;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P70Test {

    private final P70 p70 = new P70();

    private static Stream<Arguments> data() {
        return Stream.of( //the same as fibonacci sequence but shifted one step right
                arguments(1, 1),
                arguments(2, 2),
                arguments(3, 3),
                arguments(4, 5),
                arguments(5, 8),
                arguments(30, 1346269),
                arguments(45, 1836311903)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void climbStairs(int input, int expected) {
        assertThat(p70.climbStairs(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void climbStairsFlat(int input, int expected) {
        assertThat(p70.climbStairsFlat(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void climbStairsRecursion(int input, int expected) {
        assertThat(p70.climbStairsRecursion(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void climbStairsRecursionWithMemorization(int input, int expected) {
        assertThat(p70.climbStairsRecursionWithMemorization(input)).isEqualTo(expected);
    }
}
