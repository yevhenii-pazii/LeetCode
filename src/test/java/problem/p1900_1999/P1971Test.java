package problem.p1900_1999;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1971Test {

    private final P1971 p1971 = new P1971();

    private static Stream<Arguments> args() {
        return Stream.of(
                arguments(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2, true),
                arguments(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5, false)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("args")
    void validPath(int n, int[][] edges, int source, int destination, boolean valid) {
        assertThat(p1971.validPath(n, edges, source, destination)).isEqualTo(valid);
    }

    @ParameterizedTest
    @MethodSource("args")
    void validPathBFS(int n, int[][] edges, int source, int destination, boolean valid) {
        assertThat(p1971.validPathBFS(n, edges, source, destination)).isEqualTo(valid);
    }

    @ParameterizedTest
    @MethodSource("args")
    void validPathRecursion(int n, int[][] edges, int source, int destination, boolean valid) {
        assertThat(p1971.validPathRecursion(n, edges, source, destination)).isEqualTo(valid);
    }

    @ParameterizedTest
    @MethodSource("args")
    void validPathUnionFind(int n, int[][] edges, int source, int destination, boolean valid) {
        assertThat(p1971.validPathUnionFind(n, edges, source, destination)).isEqualTo(valid);
    }

}