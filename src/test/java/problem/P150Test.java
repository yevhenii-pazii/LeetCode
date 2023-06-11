package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P150Test {

    private final P150 p150 = new P150();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new String[]{"2", "1", "+", "3", "*"}, 9),
                arguments(new String[]{"4", "13", "5", "/", "+"}, 6),
                arguments(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}, 22)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void evalRPNInplace(String[] tokens, int expected) {
        assertThat(p150.evalRPNInplace(tokens)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void evalRPNStack(String[] tokens, int expected) {
        assertThat(p150.evalRPNStack(tokens)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void evalRPNStackV2(String[] tokens, int expected) {
        assertThat(p150.evalRPNStackV2(tokens)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void evalRPNStackV3(String[] tokens, int expected) {
        assertThat(p150.evalRPNStackV3(tokens)).isEqualTo(expected);
    }
}
