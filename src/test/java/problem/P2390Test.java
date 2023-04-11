package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P2390Test {

    private final P2390 p2390 = new P2390();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("leet**cod*e", "lecoe"),
                arguments("erase*****", "")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeStarsStack(String s, String expected) {
        assertThat(p2390.removeStarsStack(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeStarsArray(String s, String expected) {
        assertThat(p2390.removeStarsArray(s)).isEqualTo(expected);
    }
}
