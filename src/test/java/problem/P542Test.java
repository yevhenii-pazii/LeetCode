package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P542Test {

    private final P542 p542 = new P542();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(
                        new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}},
                        new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}),
                arguments(
                        new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}},
                        new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}})
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    void updateMatrixQueue(int[][] mat, int[][] expected) {
        assertThat(p542.updateMatrixQueue(mat)).isDeepEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("data")
    void updateMatrixQueueV2(int[][] mat, int[][] expected) {
        assertThat(p542.updateMatrixQueueV2(mat)).isDeepEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void updateMatrixQueueV3(int[][] mat, int[][] expected) {
        assertThat(p542.updateMatrixQueueV3(mat)).isDeepEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void updateMatrixQueueV4(int[][] mat, int[][] expected) {
        assertThat(p542.updateMatrixQueueV4(mat)).isDeepEqualTo(expected);
    }
}
