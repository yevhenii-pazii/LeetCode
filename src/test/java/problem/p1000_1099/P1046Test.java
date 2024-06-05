package problem.p1000_1099;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1046Test {

    private final P1046 p1046 = new P1046();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{2, 7, 4, 1, 8, 1}, 1),
                arguments(new int[]{5}, 5),
                arguments(new int[]{5, 5}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void lastStoneWeightPriorityQueue(int[] stones, int expected) {
        assertThat(p1046.lastStoneWeightPriorityQueue(stones)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void lastStoneWeightHeap(int[] stones, int expected) {
        assertThat(p1046.lastStoneWeightHeap(stones)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void lastStoneWeightArraysSort(int[] stones, int expected) {
        assertThat(p1046.lastStoneWeightArraysSort(stones)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void lastStoneWeightArraysInsertingSort(int[] stones, int expected) {
        assertThat(p1046.lastStoneWeightArraysInsertingSort(stones)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void lastStoneWeightArraysInsertingSortV2(int[] stones, int expected) {
        assertThat(p1046.lastStoneWeightArraysInsertingSortV2(stones)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void lastStoneWeightArraysSortAndInsertingSort(int[] stones, int expected) {
        assertThat(p1046.lastStoneWeightArraysSortAndInsertingSort(stones)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void lastStoneWeightArraysCountingSort(int[] stones, int expected) {
        assertThat(p1046.lastStoneWeightArraysCountingSort(stones)).isEqualTo(expected);
    }
}
