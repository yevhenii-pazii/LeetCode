package problem.p0300_0399;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P394Test {

    private final P394 p394 = new P394();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("b3[a]rg", "baaarg"),
                arguments("3[a]2[bc]", "aaabcbc"),
                arguments("3[a2[c]]", "accaccacc"),
                arguments("2[abc]3[cd]ef", "abcabccdcdcdef")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void decodeString(String s, String expected) {
        assertThat(p394.decodeString(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void decodeStringDeque(String s, String expected) {
        assertThat(p394.decodeStringDeque(s)).isEqualTo(expected);
    }
}
