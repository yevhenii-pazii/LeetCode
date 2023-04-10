package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P760Test {

    private final P760 p760 = new P760();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28}, new int[]{1, 4, 3, 2, 0}),
                arguments(new int[]{84, 46}, new int[]{84, 46}, new int[]{0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void anagramMappingsHashMap(int[] nums1, int[] nums2, int[] expected) {
        assertThat(p760.anagramMappingsHashMap(nums1, nums2)).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void anagramMappingsSorting(int[] nums1, int[] nums2, int[] expected) {
        assertThat(p760.anagramMappingsSorting(nums1, nums2)).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void anagramMappingsBitShiftAndSort(int[] nums1, int[] nums2, int[] expected) {
        assertThat(p760.anagramMappingsBitShiftAndSort(nums1, nums2)).containsExactly(expected);
    }
}
