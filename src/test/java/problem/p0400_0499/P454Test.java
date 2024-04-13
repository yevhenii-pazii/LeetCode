package problem.p0400_0499;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P454Test {

    private final P454 p454 = new P454();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}, 2),
                arguments(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, 1),
                arguments(new int[]{-1,-1}, new int[]{-1,1}, new int[]{-1,1}, new int[]{1,-1}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void fourSumCountBruteForce(int[] nums1, int[] nums2, int[] nums3, int[] nums4, int expected) {
        assertThat(p454.fourSumCountBruteForce(nums1, nums2, nums3, nums4)).isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("data")
    void fourSumCountHashMap(int[] nums1, int[] nums2, int[] nums3, int[] nums4, int expected) {
        assertThat(p454.fourSumCountHashMap(nums1, nums2, nums3, nums4)).isEqualTo(expected);
    }

}
