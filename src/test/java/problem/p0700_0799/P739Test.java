package problem.p0700_0799;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P739Test {

    private final P739 p739 = new P739();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{73, 74, 75, 71, 69, 72, 76, 73}, new int[]{1, 1, 4, 2, 1, 1, 0, 0}),
                arguments(new int[]{30, 40, 50, 60}, new int[]{1, 1, 1, 0}),
                arguments(new int[]{50, 40, 30, 30}, new int[]{0, 0, 0, 0}),
                arguments(new int[]{77, 77, 77, 77, 77, 41, 77, 41, 41, 77}, new int[]{0, 0, 0, 0, 0, 1, 0, 2, 1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void dailyTemperaturesBruteForce(int[] temperatures, int[] expected) {
        assertThat(p739.dailyTemperaturesBruteForce(temperatures)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void dailyTemperaturesStack(int[] temperatures, int[] expected) {
        assertThat(p739.dailyTemperaturesStack(temperatures)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void dailyTemperaturesStackV2(int[] temperatures, int[] expected) {
        assertThat(p739.dailyTemperaturesStackV2(temperatures)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void dailyTemperaturesStackV3(int[] temperatures, int[] expected) {
        assertThat(p739.dailyTemperaturesStackV3(temperatures)).containsExactlyInAnyOrder(expected);
    }
}
