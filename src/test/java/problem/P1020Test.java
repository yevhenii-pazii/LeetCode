package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P1020Test {

    private final P1020 p1020 = new P1020();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[][]{
                        {0, 0, 0, 0},
                        {1, 0, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 0}}, 3),
                arguments(new int[][]{
                        {0, 1, 1, 0},
                        {0, 0, 1, 0},
                        {0, 0, 1, 0},
                        {0, 0, 0, 0}}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void numEnclavesUnionFind(int[][] grid, int expected) {
        assertThat(p1020.numEnclavesUnionFind(grid)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void numEnclavesUnionFindWithTranslation(int[][] grid, int expected) {
        assertThat(p1020.numEnclavesUnionFindWithTranslation(grid)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void numEnclavesRecursion(int[][] grid, int expected) {
        assertThat(p1020.numEnclavesRecursion(grid)).isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("data")
    void numEnclavesLoop(int[][] grid, int expected) {
        assertThat(p1020.numEnclavesLoop(grid)).isEqualTo(expected);
    }
}
