package problem.p0000_0099;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P67Test {

    private final P67 p67 = new P67();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("0", "0", "0"),
                arguments("10", "1", "11"),
                arguments("11", "1", "100"),
                arguments("1010", "1011", "10101")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void addBinaryMath(String a, String b, String expected) {
        assertThat(p67.addBinaryMath(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void addBinaryMathBigInt(String a, String b, String expected) {
        assertThat(p67.addBinaryMathBigInt(a, b)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void addBinary(String a, String b, String expected) {
        assertThat(p67.addBinary(a, b)).isEqualTo(expected);
    }
}
