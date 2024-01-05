package problem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P300Test {

    private final P300 p300 = new P300();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[] {10,9,2,5,3,7,101,18}, 4),
                arguments(new int[] {0,1,0,3,2,3}, 4),
                arguments(new int[] {7,7,7,7,7,7,7}, 1)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void lengthOfLIS(int[] nums, int result) {
        Assertions.assertThat(p300.lengthOfLIS(nums)).isEqualTo(result);
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void lengthOfLISBruteForce(int[] nums, int result) {
        Assertions.assertThat(p300.lengthOfLISBruteForce(nums)).isEqualTo(result);
    }
}
