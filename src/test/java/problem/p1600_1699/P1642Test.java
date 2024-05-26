package problem.p1600_1699;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1642Test {

    private final P1642 p1642 = new P1642();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2, 7),
            arguments(new int[]{14, 3, 19, 3}, 17, 0, 3),
            arguments(new int[]{7, 5, 13}, 0, 0, 1)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void furthestBuilding(int[] heights, int bricks, int ladders, int result) {
        assertThat(p1642.furthestBuilding(heights, bricks, ladders)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void furthestBuildingHeap(int[] heights, int bricks, int ladders, int result) {
        assertThat(p1642.furthestBuildingHeap(heights, bricks, ladders)).isEqualTo(result);
    }

}
