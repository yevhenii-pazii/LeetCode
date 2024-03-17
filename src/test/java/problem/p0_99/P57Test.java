package problem.p0_99;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class P57Test {

    private final P57 p57 = new P57();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}, new int[][]{{1, 5}, {6, 9}}),
                arguments(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}, new int[][]{{1, 2}, {3, 10}, {12, 16}}),
                arguments(new int[][]{{1, 2}, {5, 6}}, new int[]{3, 4}, new int[][]{{1, 2}, {3, 4}, {5, 6}}),
                arguments(new int[][]{{1, 5}, {6, 7}}, new int[]{2, 3}, new int[][]{{1, 5}, {6, 7}}),
                arguments(new int[][] {}, new int[]{5,6}, new int[][]{{5,6}}),
                arguments(new int[][] {{1,5}}, new int[]{6,8}, new int[][]{{1,5}, {6,8}}),
                arguments(new int[][] {{1,5}}, new int[]{0,0}, new int[][]{{0,0}, {1,5}})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void insert(int[][] intervals, int[] newInterval, int[][] result) {
        Assertions.assertThat(p57.insert(intervals, newInterval)).isDeepEqualTo(result);
    }

}