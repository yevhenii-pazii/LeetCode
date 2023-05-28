package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P347Test {

    private final P347 p347 = new P347();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2}),
                arguments(new int[]{1}, 1, new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void topKFrequentMapAndPriorityQueue(int[] nums, int k, int[] expected) {
        assertThat(p347.topKFrequentMapAndPriorityQueue(nums, k)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void topKFrequentMapAndPriorityQueueV2(int[] nums, int k, int[] expected) {
        assertThat(p347.topKFrequentMapAndPriorityQueueV2(nums, k)).containsExactlyInAnyOrder(expected);
    }
}
