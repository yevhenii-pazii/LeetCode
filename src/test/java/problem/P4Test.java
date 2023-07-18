package problem;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P4Test {

    private final P4 p4 = new P4();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 3}, new int[]{2}, 2.0),
                arguments(new int[]{1, 2}, new int[]{3, 4}, 2.5),
                arguments(new int[]{1, 3}, new int[]{2, 4}, 2.5),
                arguments(new int[]{2, 4}, new int[]{1, 3}, 2.5),
                arguments(new int[]{}, new int[]{3, 4, 5}, 4.0),
                arguments(new int[]{}, new int[]{3, 4, 5, 6}, 4.5),
                arguments(new int[]{3, 4, 5}, new int[]{}, 4.0),
                arguments(new int[]{3, 4, 5, 6}, new int[]{}, 4.5)
        );
    }


    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void indMedianSortedArrays(int[] nums1, int[] nums2, double expected) {
        assertThat(p4.findMedianSortedArrays(nums1, nums2))
                .isCloseTo(expected, Offset.offset(0.000001));
    }
}
