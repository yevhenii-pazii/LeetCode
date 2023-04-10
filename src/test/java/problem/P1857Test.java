package problem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P1857Test {

    private final P1857 p1857 = new P1857();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("abaca", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}}, 3),
                arguments("a", new int[][]{{0, 0}}, -1),
                arguments("hhqhuqhqff", new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}, {3, 5}, {5, 6}, {2, 7},
                        {6, 7}, {7, 8}, {3, 8}, {5, 8}, {8, 9}, {3, 9}, {6, 9}}, 3),
                arguments("iivvvvv", new int[][]{{0, 1}, {1, 2}, {1, 3}, {2, 3}, {3, 4}, {2, 4}, {3, 5},
                        {1, 5}, {4, 5}, {5, 6}}, 5)

        );
    }


    @ParameterizedTest
    @MethodSource("data")
    void largestPathValue(String colors, int[][] edges, int expected) {
        assertThat(p1857.largestPathValue(colors, edges)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void largestPathValueRecursion(String colors, int[][] edges, int expected) {
        assertThat(p1857.largestPathValueRecursion(colors, edges)).isEqualTo(expected);
    }
}
