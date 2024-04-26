package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P2218Test {

    private final P2218 p2218 = new P2218();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(of(of(1, 100, 3), of(7, 8, 9)), 2, 101),
                arguments(of(of(1, 100, 3), of(7, 8, 9), of(5, 800, 5)), 3, 812),
                arguments(of(
                        of(100),
                        of(100),
                        of(100),
                        of(100),
                        of(100),
                        of(100),
                        of(1, 1, 1, 1, 1, 1, 700)), 7, 706)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void maxValueOfCoins(List<List<Integer>> piles, int k, int expected) {
        assertThat(p2218.maxValueOfCoins(piles, k)).isEqualTo(expected);
    }
}
