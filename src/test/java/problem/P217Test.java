package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P217Test {

    private final P217 p217 = new P217();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 1}, true),
                arguments(new int[]{1, 2, 3, 4}, false),
                arguments(new int[]{-1 * (int) Math.pow(10, 9), (int) Math.pow(10, 9)}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void containsDuplicateBruteForce(int[] nums, boolean expected) {
        assertThat(p217.containsDuplicateBruteForce(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void containsDuplicateSorting(int[] nums, boolean expected) {
        assertThat(p217.containsDuplicateSorting(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void containsDuplicateArrayAsHashTable(int[] nums, boolean expected) {
        assertThat(p217.containsDuplicateArrayAsHashTable(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void containsDuplicateHashSet(int[] nums, boolean expected) {
        assertThat(p217.containsDuplicateHashSet(nums)).isEqualTo(expected);
    }
}
