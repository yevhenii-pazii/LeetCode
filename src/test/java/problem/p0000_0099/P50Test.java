package problem.p0000_0099;

import org.assertj.core.data.Offset;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P50Test {

    private final P50 p50 = new P50();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(2.0, 10, 1024.0),
                arguments(2.1, 3, 9.261),
                arguments(2.0, -2, 0.25)
        );
    }

    private static Stream<Arguments> dataHugeNumbers() {
        return Stream.of(
                arguments(0.00001, 2147483647, 0.0),
                arguments(2.0, Integer.MIN_VALUE, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource({"data", "dataHugeNumbers"})
    void myPow(double x, int n, double expected) {
        assertThat(p50.myPow(x, n)).isCloseTo(expected, Offset.offset(0.001));
    }

    @ParameterizedTest
    @MethodSource("data")
    void myPowRecursion(double x, int n, double expected) {
        assertThat(p50.myPowRecursion(x, n)).isCloseTo(expected, Offset.offset(0.001));
    }

    @ParameterizedTest
    @MethodSource({"data", "dataHugeNumbers"})
    void myPowFlat(double x, int n, double expected) {
        assertThat(p50.myPowFlat(x, n)).isCloseTo(expected, Offset.offset(0.001));
    }


    @ParameterizedTest
    @MethodSource({"data", "dataHugeNumbers"})
    void myPowMath(double x, int n, double expected) {
        assertThat(p50.myPowMath(x, n)).isCloseTo(expected, Offset.offset(0.001));
    }
}
