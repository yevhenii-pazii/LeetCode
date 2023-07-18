package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P215Test {

    private final P215 p215 = new P215();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{3, 2, 1, 5, 6, 4}, 2, 5),
                arguments(new int[]{3, 2, 1, 5, 6, 4}, 6, 1),
                arguments(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4, 4),
                arguments(new int[]{2, 1}, 2, 1)
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    void findKthLargestBruteForce(int[] nums, int k, int expected) {
        assertThat(p215.findKthLargestBruteForce(nums, k)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findKthLargestPriorityQueue(int[] nums, int k, int expected) {
        assertThat(p215.findKthLargestPriorityQueue(nums, k)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findKthLargestPriorityQueueV2(int[] nums, int k, int expected) {
        assertThat(p215.findKthLargestPriorityQueueV2(nums, k)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findKthLargestCountingSort(int[] nums, int k, int expected) {
        assertThat(p215.findKthLargestCountingSort(nums, k)).isEqualTo(expected);
    }
}
