package problem.p0400_0499;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P409Test {

    private final P409 p409 = new P409();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments("abccccdd", 7),
            arguments("a", 1)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void longestPalindrome(String s, int result) {
        assertThat(p409.longestPalindrome(s)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void longestPalindromeHashMap(String s, int result) {
        assertThat(p409.longestPalindromeHashMap(s)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void longestPalindromeArray(String s, int result) {
        assertThat(p409.longestPalindromeArray(s)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void longestPalindromeArrayOneLoop(String s, int result) {
        assertThat(p409.longestPalindromeArrayOneLoop(s)).isEqualTo(result);
    }

}
