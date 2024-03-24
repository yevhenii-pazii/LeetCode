package problem.p0200_0299;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P245Test {

    private final P245 p245 = new P245();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding", 1),
                arguments(new String[] {"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes", 3)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void shortestWordDistance(String[] wordsDict, String word1, String word2, int expected) {
        assertThat(p245.shortestWordDistance(wordsDict, word1, word2)).isEqualTo(expected);
    }
}
