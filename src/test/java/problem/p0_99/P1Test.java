package problem.p0_99;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P1Test {

    private final P1 p1 = new P1();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                arguments(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                arguments(new int[]{3, 3}, 6, new int[]{0, 1})

        );
    }

    @Disabled("It is to slow")
    @ParameterizedTest
    @MethodSource("data")
    void twoSumWithArrayAsMap(int[] nums, int target, int[] expected) {
        assertThat(p1.twoSumWithArrayAsMap(nums, target)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void twoSumWithMapTwoPass(int[] nums, int target, int[] expected) {
        assertThat(p1.twoSumWithMapTwoPass(nums, target)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void twoSumWithMapSinglePass(int[] nums, int target, int[] expected) {
        assertThat(p1.twoSumWithMapSinglePass(nums, target)).containsExactlyInAnyOrder(expected);
    }
}
