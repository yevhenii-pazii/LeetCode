package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P2300Test {

    private final P2300 p2300 = new P2300();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7L, new int[]{4, 0, 3}),
                arguments(new int[]{5, 1, 3}, new int[]{5, 4, 3, 2, 1}, 7L, new int[]{4, 0, 3}),
                arguments(new int[]{5, 1, 3}, new int[]{3, 5, 1, 2, 4}, 7L, new int[]{4, 0, 3}),

                arguments(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 16L, new int[]{2, 0, 0})
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    void successfulPairsBruteForce(int[] spells, int[] potions, long success, int[] expected) {
        assertThat(p2300.successfulPairsBruteForce(spells, potions, success))
                .containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void successfulPairsWithSortingAndBinarySearch(int[] spells, int[] potions, long success, int[] expected) {
        assertThat(p2300.successfulPairsWithSortingAndBinarySearch(spells, potions, success))
                .containsExactly(expected);
    }
}
