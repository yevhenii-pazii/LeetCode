package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P20Test {

    private final P20 p20 = new P20();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("", true),
                arguments("()", true),
                arguments("()[]{}", true),
                arguments("(]", false),
                arguments("()]", false),
                arguments("((", false),
                arguments("))", false)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void isValid(String s, boolean expected) {
        assertThat(p20.isValid(s)).isEqualTo(expected);
    }
}
