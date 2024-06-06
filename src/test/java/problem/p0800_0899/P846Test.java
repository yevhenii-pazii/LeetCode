package problem.p0800_0899;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P846Test {

    private final P846 p846 = new P846();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[]{1, 2, 3}, 1, true),
            arguments(new int[]{1, 2, 3, 6, 2, 3, 4, 7, 8}, 3, true),
            arguments(new int[]{1, 2, 3, 4, 5}, 4, false),
            arguments(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 3}, 3, true),
            arguments(new int[]{1, 1, 1, 2, 2, 2, 3, 3, 4}, 3, false)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void isNStraightHand(int[] hand, int groupSize, boolean result) {
        assertThat(p846.isNStraightHand(hand, groupSize)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isNStraightHandV1(int[] hand, int groupSize, boolean result) {
        assertThat(p846.isNStraightHandV1(hand, groupSize)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isNStraightHandV2(int[] hand, int groupSize, boolean result) {
        assertThat(p846.isNStraightHandV2(hand, groupSize)).isEqualTo(result);
    }

}
