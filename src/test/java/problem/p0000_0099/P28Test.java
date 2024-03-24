package problem.p0000_0099;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P28Test {

    private final P28 p28 = new P28();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("sadbutsad", "sad", 0),
                arguments("leetcode", "leeto", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void strStrJava(String haystack, String needle, int expected) {
        assertThat(p28.strStrJava(haystack, needle)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void strStrOwn(String haystack, String needle, int expected) {
        assertThat(p28.strStrOwn(haystack, needle)).isEqualTo(expected);
    }
}
