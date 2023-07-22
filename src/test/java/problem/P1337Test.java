package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P1337Test {

    private final P1337 p1337 = new P1337();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}}, 3, new int[]{2, 0, 3}),
                arguments(new int[][]{
                        {1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0}}, 2, new int[]{0, 2})
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    void kWeakestRowsPriorityQueue(int[][] mat, int k, int[] expected) {
        assertThat(p1337.kWeakestRowsPriorityQueue(mat, k)).hasSize(k).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void kWeakestRowsMaxHeap(int[][] mat, int k, int[] expected) {
        assertThat(p1337.kWeakestRowsMaxHeap(mat, k)).hasSize(k).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void kWeakestRowsMaxHeapAndBinarySearch(int[][] mat, int k, int[] expected) {
        assertThat(p1337.kWeakestRowsMaxHeapAndBinarySearch(mat, k)).hasSize(k).containsExactly(expected);
    }
}
