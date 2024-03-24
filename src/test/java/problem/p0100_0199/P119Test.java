package problem.p0100_0199;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P119Test {

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
    void getRowLoop(int rowIndex, List<Integer> expected) {
        assertThat(p119.getRowLoop(rowIndex)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void getRowLoopV2(int rowIndex, List<Integer> expected) {
        assertThat(p119.getRowLoopV2(rowIndex)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void getRowRecursion(int rowIndex, List<Integer> expected) {
        assertThat(p119.getRowRecursion(rowIndex)).isEqualTo(expected);
    }
}
