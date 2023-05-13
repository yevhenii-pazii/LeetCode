package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P205Test {

    private final P205 p205 = new P205();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("egg", "add", true),
                arguments("foo", "bar", false),
                arguments("paper", "title", true)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void isIsomorphicMap(String s, String t, boolean expected) {
        assertThat(p205.isIsomorphicMap(s, t)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isIsomorphicArray(String s, String t, boolean expected) {
        assertThat(p205.isIsomorphicArray(s, t)).isEqualTo(expected);
    }
}
