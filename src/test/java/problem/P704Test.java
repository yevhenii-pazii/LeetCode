package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P704Test {

    private final P704 p704 = new P704();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{}, 5, -1),
                arguments(new int[]{5}, 5, 0),
                arguments(new int[]{-1, 0, 3, 5, 9, 12}, 3, 2),
                arguments(new int[]{-1, 0, 3, 5, 9, 12}, 9, 4),
                arguments(new int[]{-1, 0, 3, 5, 9, 12}, 12, 5),
                arguments(new int[]{-1, 0, 3, 5, 9, 12}, 2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void search(int[] array, int target, int expected) {
        assertThat(p704.search(array, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void search2(int[] array, int target, int expected) {
        assertThat(p704.search2(array, target)).isEqualTo(expected);
    }
}
