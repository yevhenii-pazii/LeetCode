package problem.p0100_0199;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P170Test {

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(List.of(1, 3, 5), Map.of(4, true, 7, false)),
                arguments(List.of(1, -1), Map.of(0, true)),
                arguments(List.of(3, 2, 1),
                        Map.of(2, false, 3, true, 4, true, 5, true, 6, false))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void twoSumSortedAndTwoPointers(List<Integer> numbers, Map<Integer, Boolean> expected) {
        var twoSum = new P170.TwoSumSortedAndTwoPointers();

        for (var n : numbers) {
            twoSum.add(n);
        }

        for (var e : expected.entrySet()) {
            assertThat(twoSum.find(e.getKey())).isEqualTo(e.getValue());
        }
    }
}
