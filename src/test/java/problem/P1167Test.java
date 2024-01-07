package problem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1167Test {

    private final P1167 p1167 = new P1167();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{2, 4, 3}, 14),
                arguments(new int[]{1, 8, 3, 5}, 30),
                arguments(new int[]{5}, 0),
                arguments(new int[]{3354, 4316, 3259, 4904, 4598, 474, 3166, 6322, 8080, 9009}, 151646),
                arguments(new int[]{
                        1175, 8967, 1382, 8748, 8612, 7067, 5979, 8237, 9691, 389, 5801, 7387, 8620, 6674,
                        1610, 7444, 6969, 970, 9463, 7727, 5044, 1834, 3426, 3192, 9473, 2300, 3647, 6492,
                        3166, 3486, 454, 6077, 670, 4929, 1266, 8288, 8554, 8432, 4724, 8553, 2442, 1776,
                        2704, 1276, 2933, 3376, 8259, 8548, 1563, 3884}, 1363767),
                arguments(new int[]{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1}, 864)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void connectSticks(int[] sticks, int result) {
        assertThat(p1167.connectSticks(sticks)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void connectSticksPriorityQueue(int[] sticks, int result) {
        assertThat(p1167.connectSticksPriorityQueue(sticks)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void connectSticksArrayHeap(int[] sticks, int result) {
        assertThat(p1167.connectSticksArrayHeap(sticks)).isEqualTo(result);
    }
}
