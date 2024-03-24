package problem.p0000_0099;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P34Test {

    private final P34 p34 = new P34();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4}),
                arguments(new int[]{5, 7, 7, 8, 8, 8, 10}, 8, new int[]{3, 5}),
                arguments(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1}),
                arguments(new int[]{}, 8, new int[]{-1, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void searchRangeBruteForce(int[] nums, int target, int[] expected) {
        assertThat(p34.searchRangeBruteForce(nums, target)).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void searchRangeBinarySearch(int[] nums, int target, int[] expected) {
        assertThat(p34.searchRangeBinarySearch(nums, target)).containsExactly(expected);
    }
}
