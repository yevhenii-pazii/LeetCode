package problem.p0700_0799;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P744Test {

    private final P744 p744 = new P744();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new char[]{'c', 'f', 'j'}, 'a', 'c'),
                arguments(new char[]{'c', 'f', 'j'}, 'c', 'f'),
                arguments(new char[]{'x', 'x', 'y', 'y'}, 'z', 'x')
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void nextGreatestLetterBinarySearchTemplate1(char[] letters, char target, char expected) {
        assertThat(p744.nextGreatestLetterBinarySearchTemplate1(letters, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void nextGreatestLetterBinarySearchTemplate3(char[] letters, char target, char expected) {
        assertThat(p744.nextGreatestLetterBinarySearchTemplate3(letters, target)).isEqualTo(expected);
    }
}
