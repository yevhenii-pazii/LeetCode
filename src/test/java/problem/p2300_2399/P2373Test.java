package problem.p2300_2399;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P2373Test {

    private final P2373 p2373 = new P2373();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[][]{
                    {9, 9, 8, 1},
                    {5, 6, 2, 6},
                    {8, 2, 6, 4},
                    {6, 2, 2, 2}},
                new int[][]{
                    {9, 9},
                    {8, 6}}),
            arguments(new int[][]{
                    {1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1},
                    {1, 1, 2, 1, 1},
                    {1, 1, 1, 1, 1},
                    {1, 1, 1, 1, 1}},
                new int[][]{
                    {2, 2, 2},
                    {2, 2, 2},
                    {2, 2, 2}})
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void largestLocal(int[][] grid, int[][] result) {
        assertThat(p2373.largestLocal(grid)).isDeepEqualTo(result);
    }


    @ParameterizedTest
    @MethodSource("data")
    void largestLocalArray(int[][] grid, int[][] result) {
        assertThat(p2373.largestLocalArray(grid)).isDeepEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void largestLocalArray2(int[][] grid, int[][] result) {
        assertThat(p2373.largestLocalArray2(grid)).isDeepEqualTo(result);
    }
}