package problem.p0200_0299;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P253Test {

    private final P253 p253 = new P253();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[][]{{0, 30}, {5, 10}, {15, 20}}, 2),
                arguments(new int[][]{{7, 10}, {2, 4}}, 1),
                arguments(new int[][]{{13,15},{1,13},{6,9}}, 2)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void minMeetingRooms(int[][] intervals, int expected) {
        assertThat(p253.minMeetingRooms(intervals)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void minMeetingRoomsPriorityQueue(int[][] intervals, int expected) {
        assertThat(p253.minMeetingRoomsPriorityQueue(intervals)).isEqualTo(expected);
    }
}
