package problem.p0400_0499;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P402Test {

    private final P402 p402 = new P402();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("1432219", 3, "1219"),
                arguments("10200", 1, "200"),
                arguments("10", 2, "0"),
                arguments("10001", 4, "0"),
                arguments("1234567890", 9, "0")
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void removeKdigits(String num, int k, String result) {
        assertThat(p402.removeKdigits(num, k)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeKdigitsM(String num, int k, String result) {
        assertThat(p402.removeKdigitsM(num, k)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeKdigitsLinear(String num, int k, String result) {
        assertThat(p402.removeKdigitsLinear(num, k)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeKdigitsInPlace(String num, int k, String result) {
        assertThat(p402.removeKdigitsInPlace(num, k)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeKdigitsInPlaceWithStack(String num, int k, String result) {
        assertThat(p402.removeKdigitsInPlaceWithStack(num, k)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void removeKdigitsOfficial(String num, int k, String result) {
        assertThat(p402.removeKdigitsOfficial(num, k)).isEqualTo(result);
    }
}