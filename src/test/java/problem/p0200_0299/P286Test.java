package problem.p0200_0299;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.lang.Integer.MAX_VALUE;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P286Test {

    private final P286 p286 = new P286();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[][]{
                        {MAX_VALUE, -1, 0, MAX_VALUE},
                        {MAX_VALUE, MAX_VALUE, MAX_VALUE, -1},
                        {MAX_VALUE, -1, MAX_VALUE, -1},
                        {0, -1, MAX_VALUE, MAX_VALUE}
                }, new int[][]{
                        {3, -1, 0, 1},
                        {2, 2, 1, -1},
                        {1, -1, 2, -1},
                        {0, -1, 3, 4}
                }),
                arguments(new int[][]{{-1}}, new int[][]{{-1}})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void wallsAndGates(int[][] rooms, int[][] expected) {
        p286.wallsAndGates(rooms);
        Assertions.assertThat(rooms).isDeepEqualTo(expected);
    }

}
