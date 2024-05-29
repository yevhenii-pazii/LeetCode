package problem.p1400_1499;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1404Test {

    private final P1404 p1404 = new P1404();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments("1101", 6),
            arguments("10", 1),
            arguments("1", 0),
            arguments("1111110011101010110011100100101110010100101110111010111110110010", 89) // too long for Long
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void numSteps(String s, int result) {
        assertThat(p1404.numSteps(s)).isEqualTo(result);
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void numStepsBitManipulation(String s, int result) {
        assertThat(p1404.numStepsBitManipulation(s)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void numStepsArray(String s, int result) {
        assertThat(p1404.numStepsArray(s)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void numStepsBit(String s, int result) {
        assertThat(p1404.numStepsBit(s)).isEqualTo(result);
    }

}
