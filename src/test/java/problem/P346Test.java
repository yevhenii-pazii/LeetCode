package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P346Test {

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(3, List.of(1, 10, 3, 5), List.of(1.0, 5.5, 4.66667, 6.0))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void movingAverageArray(int size, List<Integer> stream, List<Double> expected) {
        var average = new P346.MovingAverageArray(size);

        for (var i = 0; i < stream.size(); i++) {
            assertThat(average.next(stream.get(i)))
                    .as("Average for the number")
                    .isCloseTo(expected.get(i), offset(0.00001));
        }
    }

    @ParameterizedTest
    @MethodSource("data")
    void movingAverageLinkedList(int size, List<Integer> stream, List<Double> expected) {
        var average = new P346.MovingAverageLinkedList(size);

        for (var i = 0; i < stream.size(); i++) {
            assertThat(average.next(stream.get(i)))
                    .as("Average for the number")
                    .isCloseTo(expected.get(i), offset(0.00001));
        }
    }

    @ParameterizedTest
    @MethodSource("data")
    void movingAverageQueue(int size, List<Integer> stream, List<Double> expected) {
        var average = new P346.MovingAverageQueue(size);

        for (var i = 0; i < stream.size(); i++) {
            assertThat(average.next(stream.get(i)))
                    .as("Average for the number")
                    .isCloseTo(expected.get(i), offset(0.00001));
        }
    }
}
