package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P9Test {

    private final P9 p9 = new P9();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(121, true),
                arguments(-121, false),
                arguments(10, false),
                arguments(1001, true)
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    void isPalindromeString(int x, boolean result) {
        assertThat(p9.isPalindromeString(x)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isPalindromeDivide(int x, boolean result) {
        assertThat(p9.isPalindromeDivide(x)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isPalindromeMiddleElement(int x, boolean result) {
        assertThat(p9.isPalindromeMiddleElement(x)).isEqualTo(result);
    }
}
