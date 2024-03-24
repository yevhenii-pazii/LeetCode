package problem.p0100_0199;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P151Test {

    private final P151 p151 = new P151();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("the sky is blue", "blue is sky the"),
                arguments("  hello world  ", "world hello"),
                arguments("a good   example", "example good a")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void reverseWordsTwoPointers(String s, String expected) {
        assertThat(p151.reverseWordsTwoPointers(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void reverseWordsArrayReverse(String s, String expected) {
        assertThat(p151.reverseWordsArrayReverse(s)).isEqualTo(expected);
    }
}