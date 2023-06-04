package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P200Test {

    private final P200 p200 = new P200();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'0', '1', '0', '0', '1'},
                        {'1', '0', '1', '1', '0'},
                        {'1', '0', '0', '0', '1'}
                }, 5),
                arguments(new char[][]{
                        {'1', '1', '1', '1', '0'},
                        {'1', '1', '0', '1', '0'},
                        {'1', '1', '0', '0', '0'},
                        {'0', '0', '0', '0', '0'}
                }, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void numIslandsRecursion(char[][] grid, int expected) {
        assertThat(p200.numIslandsRecursion(grid)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void numIslandsQueue(char[][] grid, int expected) {
        assertThat(p200.numIslandsQueue(grid)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void numIslandsUnionFind(char[][] grid, int expected) {
        assertThat(p200.numIslandsUnionFind(grid)).isEqualTo(expected);
    }
}
