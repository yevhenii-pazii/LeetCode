package problem.p3100_3199;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P3110Test {

    private final P3110 p3110 = new P3110();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments("hello", 13),
            arguments("zaz", 50)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void scoreOfString(String s, int result) {
        assertThat(p3110.scoreOfString(s)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void scoreOfStringV1(String s, int result) {
        assertThat(p3110.scoreOfStringV1(s)).isEqualTo(result);
    }

}
