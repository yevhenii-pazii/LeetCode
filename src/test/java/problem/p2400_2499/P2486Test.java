package problem.p2400_2499;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P2486Test {

    private final P2486 p2486 = new P2486();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments("coaching", "coding", 4),
            arguments("abcde", "a", 0),
            arguments("z", "abcde", 5)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void appendCharacters(String s, String t, int result) {
        assertThat(p2486.appendCharacters(s, t)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void appendCharactersTwoPoints(String s, String t, int result) {
        assertThat(p2486.appendCharactersTwoPoints(s, t)).isEqualTo(result);
    }

}
