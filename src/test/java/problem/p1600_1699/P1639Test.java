package problem.p1600_1699;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1639Test {

    private final P1639 p1639 = new P1639();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new String[]{"acca", "bbbb", "caca"}, "aba", 6)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void numWays(String[] words, String target, int expected) {
        assertThat(p1639.numWays(words, target)).isEqualTo(expected);
    }
}
