package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P2610Test {

    private final P2610 p2610 = new P2610();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new int[]{1, 3, 4, 1, 2, 3, 1}, List.of(List.of(1, 3, 4, 2), List.of(1, 3), List.of(1))),
                arguments(new int[]{1, 2, 3, 4}, List.of(List.of(4, 3, 2, 1)))
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    void findMatrixBruteForce(int[] input, List<List<Integer>> result) {
        var listOfLists = p2610.findMatrixBruteForce(input);

        assertThat(listOfLists).hasSize(result.size());
        for (var i = 0; i < result.size(); i++) {
            assertThat(listOfLists.get(i)).containsExactlyInAnyOrderElementsOf(result.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("data")
    void findMatrixHashSet(int[] input, List<List<Integer>> result) {
        var listOfLists = p2610.findMatrixHashSet(input);

        assertThat(listOfLists).hasSize(result.size());
        for (var i = 0; i < result.size(); i++) {
            assertThat(listOfLists.get(i)).containsExactlyInAnyOrderElementsOf(result.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("data")
    void findMatrixCounting(int[] input, List<List<Integer>> result) {
        var listOfLists = p2610.findMatrixCounting(input);

        assertThat(listOfLists).hasSize(result.size());
        for (var i = 0; i < result.size(); i++) {
            assertThat(listOfLists.get(i)).containsExactlyInAnyOrderElementsOf(result.get(i));
        }
    }

    @ParameterizedTest
    @MethodSource("data")
    void findMatrixOfficial(int[] input, List<List<Integer>> result) {
        var listOfLists = p2610.findMatrixOfficial(input);

        assertThat(listOfLists).hasSize(result.size());
        for (var i = 0; i < result.size(); i++) {
            assertThat(listOfLists.get(i)).containsExactlyInAnyOrderElementsOf(result.get(i));
        }
    }
}
