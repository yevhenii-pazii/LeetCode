package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P258Test {

    private final P258 p258 = new P258();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(11, 2),
                arguments(38, 2),
                arguments(281, 2),
                arguments(1000, 1),
                arguments(11_11_11_11_1, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void addDigitsLoop(int num, int expected) {
        assertThat(p258.addDigitsLoop(num)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void addDigitsRecursion(int num, int expected) {
        assertThat(p258.addDigitsRecursion(num)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void addDigitsMath(int num, int expected) {
        assertThat(p258.addDigitsMath(num)).isEqualTo(expected);
    }
}
