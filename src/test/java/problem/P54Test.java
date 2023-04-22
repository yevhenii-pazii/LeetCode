package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P54Test {

    private final P54 p54 = new P54();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[][]{
                                {1, 2, 3},
                                {4, 5, 6},
                                {7, 8, 9}},
                        List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)),
                arguments(new int[][]{
                                {1, 2, 3, 4},
                                {5, 6, 7, 8},
                                {9, 10, 11, 12}},
                        List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void spiralOrder(int[][] matrix, List<Integer> expected) {
        assertThat(p54.spiralOrderV2(matrix)).isEqualTo(expected);
    }
}
