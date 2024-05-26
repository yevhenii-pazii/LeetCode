package problem.p0100_0199;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P131Test {

    private final P131 p131 = new P131();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments("aab", of(of("a", "a", "b"), of("aa", "b"))),
            arguments("a", of(of("a")))
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void partition(String s, List<List<String>> result) {
        assertThat(p131.partition(s)).containsExactlyInAnyOrderElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void partitionBacktracking(String s, List<List<String>> result) {
        assertThat(p131.partitionBacktracking(s)).containsExactlyInAnyOrderElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void partitionBacktrackingV2(String s, List<List<String>> result) {
        assertThat(p131.partitionBacktrackingV2(s)).containsExactlyInAnyOrderElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void partitionBacktrackingV3(String s, List<List<String>> result) {
        assertThat(p131.partitionBacktrackingV3(s)).containsExactlyInAnyOrderElementsOf(result);
    }
}
