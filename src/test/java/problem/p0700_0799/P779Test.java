package problem.p0700_0799;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P779Test {

    private final P779 p779 = new P779();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(1, 1, 0),
                arguments(2, 1, 0),
                arguments(2, 2, 1),
                arguments(4, 7, 0),
                arguments(4, 1, 0)

        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void kthGrammarRecursion(int n, int k, int expected) {
        assertThat(p779.kthGrammarRecursion(n, k)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void kthGrammarMath(int n, int k, int expected) {
        assertThat(p779.kthGrammarMath(n, k)).isEqualTo(expected);
    }
}
