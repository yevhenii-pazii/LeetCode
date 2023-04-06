package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P1254Test {

    private final P1254 p1254 = new P1254();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 1, 1, 1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 1, 0},
                        {1, 0, 1, 0, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0, 1, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1, 0}}, 2),
                arguments(new int[][]{
                        {0, 0, 1, 0, 0},
                        {0, 1, 0, 1, 0},
                        {0, 1, 1, 1, 0}}, 1),
                arguments(new int[][]{
                        {1, 1, 1, 1, 1, 1, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 1, 1, 0, 1},
                        {1, 0, 0, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 1}}, 2),
                arguments(new int[][]{
                        {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                        {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                        {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                        {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                        {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                        {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                        {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void closedIslandUnionFind(int[][] grid, int expected) {
        assertThat(p1254.closedIslandUnionFind(grid)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void closedIslandUnionFindWithTranslation(int[][] grid, int expected) {
        assertThat(p1254.closedIslandUnionFindWithTranslation(grid)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void closedIslandRecursion(int[][] grid, int expected) {
        assertThat(p1254.closedIslandRecursion(grid)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void closedIslandTraverse(int[][] grid, int expected) {
        assertThat(p1254.closedIslandTraverse(grid)).isEqualTo(expected);
    }
}
