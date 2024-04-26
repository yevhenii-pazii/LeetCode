package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P881Test {

    private final P881 p881 = new P881();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 2}, 3, 1),
                arguments(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 5, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void numRescueBoats(int[] people, int limit, int expected) {
        assertThat(p881.numRescueBoats(people, limit)).isEqualTo(expected);
    }
}
