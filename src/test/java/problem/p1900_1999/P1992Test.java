package problem.p1900_1999;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1992Test {

    private final P1992 p1992 = new P1992();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[][]{{1, 0, 0}, {0, 1, 1}, {0, 1, 1}}, new int[][]{{0, 0, 0, 0}, {1, 1, 2, 2}}),
                arguments(new int[][]{{1, 1}, {1, 1}}, new int[][]{{0, 0, 1, 1}}),
                arguments(new int[][]{{0}}, new int[][]{})
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void findFarmland(int[][] land, int[][] result) {
        assertThat(p1992.findFarmland(land)).isDeepEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findFarmlandLoop(int[][] land, int[][] result) {
        assertThat(p1992.findFarmlandLoop(land)).isDeepEqualTo(result);
    }
}