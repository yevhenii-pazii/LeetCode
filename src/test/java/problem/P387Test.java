package problem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P387Test {

    private final P387 p387 = new P387();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("leetcode", 0),
                arguments("loveleetcode", 2),
                arguments("aabb", -1)
        );
    }

    @Disabled("need to implement")
    @ParameterizedTest
    @MethodSource("data")
    void firstUniqCharBruteForce(String s, int expected) {
        assertThat(p387.firstUniqCharBruteForce(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void firstUniqCharMap(String s, int expected) {
        assertThat(p387.firstUniqCharMap(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void firstUniqCharArray(String s, int expected) {
        assertThat(p387.firstUniqCharArray(s)).isEqualTo(expected);
    }
}
