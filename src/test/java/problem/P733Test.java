package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P733Test {
    private final P733 p733 = new P733();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2,
                        new int[][]{{2, 2, 2}, {2, 2, 0}, {2, 0, 1}})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void floodFillRecursive(int[][] image, int sr, int sc, int color, int[][] expected) {
        assertThat(p733.floodFillRecursive(image, sr, sc, color)).isDeepEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("data")
    void floodFillQueue(int[][] image, int sr, int sc, int color, int[][] expected) {
        assertThat(p733.floodFillQueue(image, sr, sc, color)).isDeepEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("data")
    void floodFillQueueV2(int[][] image, int sr, int sc, int color, int[][] expected) {
        assertThat(p733.floodFillQueueV2(image, sr, sc, color)).isDeepEqualTo(expected);
    }

}
