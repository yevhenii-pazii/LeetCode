package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P1431Test {

    private final P1431 p1431 = new P1431();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{2, 3, 5, 1, 3}, 3, List.of(true, true, true, false, true)),
                arguments(new int[]{4, 2, 1, 1, 2}, 1, List.of(true, false, false, false, false))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void kidsWithCandies(int[] candies, int extraCandies, List<Boolean> expected) {
        assertThat(p1431.kidsWithCandies(candies, extraCandies)).isEqualTo(expected);
    }
}
