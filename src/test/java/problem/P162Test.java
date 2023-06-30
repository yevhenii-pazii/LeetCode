package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P162Test {

    private final P162 p162 = new P162();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 1}, List.of(2)),
                arguments(new int[]{1, 2, 1, 3, 5, 6, 4}, List.of(5))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void findPeakElement(int[] nums, List<Integer> expected) {
        assertThat(p162.findPeakElement(nums)).isIn(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findPeakElementBinarySearch(int[] nums, List<Integer> expected) {
        assertThat(p162.findPeakElementBinarySearch(nums)).isIn(expected);
    }
}
