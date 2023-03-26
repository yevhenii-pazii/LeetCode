package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

public class P344Test {

    private final P344 p344 = new P344();

    private static Stream<Arguments> data() {
        return Stream.of(
                of(
                        new char[]{'h', 'e', 'l', 'l', 'o'},
                        new char[]{'o', 'l', 'l', 'e', 'h'}
                ),
                of(
                        new char[]{'h', 'e', 'l', 'l'},
                        new char[]{'l', 'l', 'e', 'h'}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void reverseString(char[] input, char[] expected) {
        p344.reverseString(input);
        assertThat(input).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void reverseStringRecursion(char[] input, char[] expected) {
        p344.reverseStringRecursion(input);
        assertThat(input).containsExactly(expected);
    }

}
