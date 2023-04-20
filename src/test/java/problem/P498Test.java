package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P498Test {

    private final P498 p498 = new P498();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 6},
                        new int[]{7, 8, 9}}, new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}),
                arguments(new int[][]{new int[]{1, 2}, new int[]{3, 4}}, new int[]{1, 2, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void findDiagonalOrder(int[][] mat, int[] expected) {
        assertThat(p498.findDiagonalOrder(mat)).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findDiagonalOrderV2(int[][] mat, int[] expected) {
        assertThat(p498.findDiagonalOrderV2(mat)).containsExactly(expected);
    }
}
