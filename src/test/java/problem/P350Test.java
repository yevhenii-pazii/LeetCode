package problem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P350Test {

    private final P350 p350 = new P350();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2, 2}),
                arguments(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{9, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void intersectCounting(int[] nums1, int[] nums2, int[] expected) {
        assertThat(p350.intersectCounting(nums1, nums2)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void intersectMap(int[] nums1, int[] nums2, int[] expected) {
        assertThat(p350.intersectMap(nums1, nums2)).containsExactlyInAnyOrder(expected);
    }

    @Disabled("Need to implement")
    @ParameterizedTest
    @MethodSource("data")
    void intersectTwoPointers(int[] nums1, int[] nums2, int[] expected) {
        assertThat(p350.intersectTwoPointers(nums1, nums2)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void intersectList(int[] nums1, int[] nums2, int[] expected) {
        assertThat(p350.intersectList(nums1, nums2)).containsExactlyInAnyOrder(expected);
    }
}
