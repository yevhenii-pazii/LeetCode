package problem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P561Test {

    private P561 p561 = new P561();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[] {1,4,3,2}, 4),
                arguments(new int[] {6,2,6,5,1,2}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void arrayPairSum(int[] nums, int expected) {
        assertThat(p561.arrayPairSum(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void arrayPairSumCounting(int[] nums, int expected) {
        assertThat(p561.arrayPairSumCounting(nums)).isEqualTo(expected);
    }
}
