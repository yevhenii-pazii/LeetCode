package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P973Test {

    private final P973 p973 = new P973();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[][]{{1, 3}, {-2, 2}}, 1, new int[][]{{-2, 2}}),
                arguments(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2, new int[][]{{3, 3}, {-2, 4}})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void kClosestMaxHeap(int[][] points, int k, int[][] result) {
        assertThat(p973.kClosestMaxHeap(points, k)).isDeepEqualTo(result); // TODO comparison
    }
}
