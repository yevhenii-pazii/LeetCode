package problem.p0600_0699;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P633Test {

    private final P633 p633 = new P633();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(0, true),
            arguments(1, true),
            arguments(2, true),
            arguments(3, false),
            arguments(4, true),
            arguments(5, true),
            arguments(6, false),
            arguments(1000, true)
        );
    }

    @Deprecated
    @ParameterizedTest
    @MethodSource("data")
    void judgeSquareSum(int c, boolean result) {
        assertThat(p633.judgeSquareSum(c)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void judgeSquareSumBruteForce(int c, boolean result) {
        assertThat(p633.judgeSquareSumBruteForce(c)).isEqualTo(result);
    }


    @ParameterizedTest
    @MethodSource("data")
    void judgeSquareSumTwoPoints(int c, boolean result) {
        assertThat(p633.judgeSquareSumTwoPoints(c)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void judgeSquareSumBinarySearch(int c, boolean result) {
        assertThat(p633.judgeSquareSumBinarySearch(c)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void judgeSquareSumFermatTheorem(int c, boolean result) {
        assertThat(p633.judgeSquareSumFermatTheorem(c)).isEqualTo(result);
    }

}
