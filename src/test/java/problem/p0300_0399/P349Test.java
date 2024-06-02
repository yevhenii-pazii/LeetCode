package problem.p0300_0399;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P349Test {

    private final P349 p349 = new P349();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2}),
                arguments(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{4, 9}),
                arguments(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4, 5}, new int[]{4, 5, 9})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void intersectionBruteForce(int[] nums1, int[] nums2, int[] expected) {
        assertThat(p349.intersectionBruteForce(nums1, nums2)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void intersectionHashSet(int[] nums1, int[] nums2, int[] expected) {
        assertThat(p349.intersectionHashSet(nums1, nums2)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void intersectionHashSetNative(int[] nums1, int[] nums2, int[] expected) {
        assertThat(p349.intersectionHashSetNative(nums1, nums2)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void intersectionCountingSort(int[] nums1, int[] nums2, int[] expected) {
        assertThat(p349.intersectionCountingSort(nums1, nums2)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void intersectionSortingAndBinarySearch(int[] nums1, int[] nums2, int[] expected) {
        assertThat(p349.intersectionSortingAndBinarySearch(nums1, nums2)).containsExactlyInAnyOrder(expected);
    }
}
