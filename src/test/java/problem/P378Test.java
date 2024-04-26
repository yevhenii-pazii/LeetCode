package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P378Test {

    private final P378 p378 = new P378();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15}}, 8, 13),
                arguments(new int[][]{{-5}}, 1, -5)
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    void kthSmallestPriorityQueue(int[][] matrix, int k, int expected) {
        assertThat(p378.kthSmallestPriorityQueue(matrix, k)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void kthSmallestPriorityQueueV2(int[][] matrix, int k, int expected) {
        assertThat(p378.kthSmallestPriorityQueueV2(matrix, k)).isEqualTo(expected);
    }
}
