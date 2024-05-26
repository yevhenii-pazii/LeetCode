package problem.p0000_0099;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P78Test {

    private final P78 p78 = new P78();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[]{1, 2, 3},
                of(of(), of(1), of(2), of(1, 2), of(3), of(1, 3), of(2, 3), of(1, 2, 3))),
            arguments(new int[]{0}, of(of(), of(0)))
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void subsets(int[] nums, List<List<Integer>> result) {
        assertThat(p78.subsets(nums)).containsAll(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void subsetsBacktrackingRecursion(int[] nums, List<List<Integer>> result) {
        assertThat(p78.subsetsBacktrackingRecursion(nums))
            .containsExactlyInAnyOrderElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void subsetsBacktrackingLoop(int[] nums, List<List<Integer>> result) {
        assertThat(p78.subsetsBacktrackingLoop(nums))
            .containsExactlyInAnyOrderElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void subsetsCascading(int[] nums, List<List<Integer>> result) {
        assertThat(p78.subsetsCascading(nums))
            .containsExactlyInAnyOrderElementsOf(result);
    }

}
