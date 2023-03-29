package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P119Test {

    private final P119 p119 = new P119();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(0, List.of(1)),
                arguments(1, List.of(1, 1)),
                arguments(2, List.of(1, 2, 1)),
                arguments(3, List.of(1, 3, 3, 1))
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    void getRow(int rowIndex, List<Integer> expected) {
        assertThat(p119.getRow(rowIndex)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void getRowRecursion(int rowIndex, List<Integer> expected) {
        assertThat(p119.getRowRecursion(rowIndex)).isEqualTo(expected);
    }
}
