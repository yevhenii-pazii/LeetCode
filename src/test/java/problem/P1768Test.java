package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1768Test {

    private final P1768 p1768 = new P1768();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("abc", "pqr", "apbqcr"),
                arguments("ab", "pqrs", "apbqrs"),
                arguments("abcd", "pq", "apbqcd")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void mergeAlternately(String word1, String word2, String expected) {
        assertThat(p1768.mergeAlternately(word1, word2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void mergeAlternatelyImproved(String word1, String word2, String expected) {
        assertThat(p1768.mergeAlternatelyImproved(word1, word2)).isEqualTo(expected);
    }
}
