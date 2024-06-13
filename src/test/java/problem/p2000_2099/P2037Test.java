package problem.p2000_2099;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P2037Test {

    private final P2037 p2037 = new P2037();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[]{3, 1, 5}, new int[]{2, 7, 4}, 4),
            arguments(new int[]{4, 1, 5, 9}, new int[]{1, 3, 2, 6}, 7),
            arguments(new int[]{2, 2, 6, 6}, new int[]{1, 3, 2, 6}, 4)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void minMovesToSeat(int[] seats, int[] students, int result) {
        assertThat(p2037.minMovesToSeat(seats, students)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void minMovesToSeatCounting(int[] seats, int[] students, int result) {
        assertThat(p2037.minMovesToSeatCounting(seats, students)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void minMovesToSeatSort(int[] seats, int[] students, int result) {
        assertThat(p2037.minMovesToSeatSort(seats, students)).isEqualTo(result);
    }

}
