package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P283Test {

    private final P283 p283 = new P283();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
                arguments(new int[]{0, 1, 0, 0, 3, 12}, new int[]{1, 3, 12, 0, 0, 0}),
                arguments(new int[]{0, 0}, new int[]{0, 0}),
                arguments(new int[]{1, 0}, new int[]{1, 0})

        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void moveZeroes(int[] nums, int[] expected) {
        p283.moveZeroes(nums);
        assertThat(nums).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void moveZeroesTwoPointers(int[] nums, int[] expected) {
        p283.moveZeroesTwoPointers(nums);
        assertThat(nums).isEqualTo(expected);
    }
}
