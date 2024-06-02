package problem.p0300_0399;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P367Test {

    private final P367 p367 = new P367();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(16, true),
                arguments(14, false),
                arguments(2147483647, false)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void isPerfectSquare(int num, boolean expected) {
        assertThat(p367.isPerfectSquare(num)).isEqualTo(expected);
    }
}
