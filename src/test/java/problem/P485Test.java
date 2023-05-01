package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P485Test {

    private final P485 p485 = new P485();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 1, 0, 1, 1, 1}, 3),
                arguments(new int[]{1, 0, 1, 1, 0, 1}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void findMaxConsecutiveOnes(int[] nums, int expected) {
        assertThat(p485.findMaxConsecutiveOnes(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findMaxConsecutiveOnesImproved(int[] nums, int expected) {
        assertThat(p485.findMaxConsecutiveOnesImproved(nums)).isEqualTo(expected);
    }
}
