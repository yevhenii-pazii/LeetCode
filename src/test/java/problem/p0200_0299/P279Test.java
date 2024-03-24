package problem.p0200_0299;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P279Test {

    private final P279 p279 = new P279();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(12, 3), //4 + 4 + 4 and not 9 + 1 + 1 + 1
                arguments(13, 2), // 9 + 4
                arguments(43, 3) //25 + 9 +9
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void numSquaresQueue(int n, int expected) {
        assertThat(p279.numSquaresQueue(n)).isEqualTo(expected);
    }
}
