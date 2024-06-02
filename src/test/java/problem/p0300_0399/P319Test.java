package problem.p0300_0399;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P319Test {

    private final P319 p319 = new P319();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(1, 1),
                arguments(2, 1),
                arguments(3, 1),
                arguments(4, 2),
                arguments(8, 2),
                arguments(9, 3),
                arguments(10, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void bulbSwitch(int n, int expected) {
        assertThat(p319.bulbSwitch(n)).isEqualTo(expected);
    }
}
