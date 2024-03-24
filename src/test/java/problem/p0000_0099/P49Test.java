package problem.p0000_0099;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P49Test {

    private final P49 p49 = new P49();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"},
                        List.of(List.of("bat"), List.of("nat", "tan"), List.of("ate", "eat", "tea"))),
                arguments(new String[]{""}, List.of(List.of(""))),
                arguments(new String[]{"a"}, List.of(List.of("a")))
        );
    }

    @Disabled("TODO Need to implement complex comparison")
    @ParameterizedTest
    @MethodSource("data")
    void groupAnagramsMapSortBased(String[] strs, List<List<String>> expected) {
        assertThat(p49.groupAnagramsMapSortBased(strs))
                .hasSize(expected.size())
                .containsAll(expected);
    }

    @Disabled("TODO Need to implement complex comparison")
    @ParameterizedTest
    @MethodSource("data")
    void groupAnagramsMapCountBased(String[] strs, List<List<String>> expected) {
        assertThat(p49.groupAnagramsMapCountBased(strs))
                .hasSize(expected.size())
                .containsAll(expected);
    }
}
