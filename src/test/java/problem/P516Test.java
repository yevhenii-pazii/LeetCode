package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P516Test {

    private final P516 p516 = new P516();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("bbbab", 4),
                arguments("cbbd", 2),
                arguments("aabaa", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void longestPalindromeSubseqReqursion(String s, int expected) {
        assertThat(p516.longestPalindromeSubseqReqursion(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void longestPalindromeSubseqReqursionWithMemorization(String s, int expected) {
        assertThat(p516.longestPalindromeSubseqReqursionWithMemorization(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void longestPalindromeSubseqIterativeWithMemorization(String s, int expected) {
        assertThat(p516.longestPalindromeSubseqIterativeWithMemorization(s)).isEqualTo(expected);
    }
}
