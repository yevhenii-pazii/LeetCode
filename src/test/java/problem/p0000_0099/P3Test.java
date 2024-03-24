package problem.p0000_0099;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P3Test {

    private final P3 p3 = new P3();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("abcabcbb", 3),
                arguments("bbbbb", 1),
                arguments("pwwkew", 3)

        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void lengthOfLongestSubstringMap(String s, int expected) {
        assertThat(p3.lengthOfLongestSubstringMap(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void lengthOfLongestSubstringArray(String s, int expected) {
        assertThat(p3.lengthOfLongestSubstringArray(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void lengthOfLongestSubstringMapIndex(String s, int expected) {
        assertThat(p3.lengthOfLongestSubstringMapIndex(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void lengthOfLongestSubstringArrayIndex(String s, int expected) {
        assertThat(p3.lengthOfLongestSubstringArrayIndex(s)).isEqualTo(expected);
    }
}
