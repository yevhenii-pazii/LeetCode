package problem.p0600_0699;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P678Test {

    private final P678 p678 = new P678();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("()", true),
                arguments("(*)", true),
                arguments("(*))", true),
                arguments("(**", true),
                arguments("**((", false),
                arguments("*(*(", false)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void checkValidString(String s, boolean expected) {
        assertThat(p678.checkValidString(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void checkValidStringTwoWays(String s, boolean expected) {
        assertThat(p678.checkValidStringTwoWays(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void checkValidStringStack(String s, boolean expected) {
        assertThat(p678.checkValidStringStack(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void checkValidStringTwo(String s, boolean expected) {
        assertThat(p678.checkValidStringTwo(s)).isEqualTo(expected);
    }
}