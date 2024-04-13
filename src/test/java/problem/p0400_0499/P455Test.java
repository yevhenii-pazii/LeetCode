package problem.p0400_0499;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P455Test {

    private final P455 p455 = new P455();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 2, 3}, new int[]{1, 1}, 1),
                arguments(new int[]{1, 2}, new int[]{1, 2, 3}, 2),
                arguments(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void findContentChildren(int[] g, int[] s, int result) {
        assertThat(p455.findContentChildren(g, s)).isEqualTo(result);
    }
}
