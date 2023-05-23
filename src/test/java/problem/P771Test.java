package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P771Test {

    private final P771 p771 = new P771();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("aA", "aAAbbbb", 3),
                arguments("z", "ZZ", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void numJewelsInStonesBruteForce(String jewels, String stones, int expected) {
        assertThat(p771.numJewelsInStonesBruteForce(jewels, stones)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void numJewelsInStonesHashSet(String jewels, String stones, int expected) {
        assertThat(p771.numJewelsInStonesHashSet(jewels, stones)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void numJewelsInStonesList(String jewels, String stones, int expected) {
        assertThat(p771.numJewelsInStonesList(jewels, stones)).isEqualTo(expected);
    }
}
