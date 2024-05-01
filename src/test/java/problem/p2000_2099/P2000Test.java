package problem.p2000_2099;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P2000Test {

    private final P2000 p2000 = new P2000();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments("abcdefd", 'd', "dcbaefd"),
            arguments("xyxzxe", 'z', "zxyxxe"),
            arguments("abcd", 'z', "abcd")
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void reversePrefix(String word, char ch, String result) {
        assertThat(p2000.reversePrefix(word, ch)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void reversePrefixTwoPoint(String word, char ch, String result) {
        assertThat(p2000.reversePrefixTwoPoint(word, ch)).isEqualTo(result);
    }

}