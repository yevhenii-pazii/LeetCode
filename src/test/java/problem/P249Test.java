package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P249Test {

    private final P249 p249 = new P249();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"},
                        List.of(
                                List.of("acef"),
                                List.of("a", "z"),
                                List.of("abc", "bcd", "xyz"), List.of("az", "ba"))),
                arguments(new String[]{"a"}, List.of(List.of("a")))
        );
    }

    /*
        TODO Improve assertions. If the list order is different it will fail, but must not
     */
    @ParameterizedTest
    @MethodSource("data")
    void groupStrings(String[] strings, List<List<String>> expected) {
        assertThat(p249.groupStrings(strings))
                .hasSize(expected.size())
                .containsAll(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void groupStringsV2(String[] strings, List<List<String>> expected) {
        assertThat(p249.groupStringsV2(strings))
                .hasSize(expected.size())
                .containsAll(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void groupStringsV3(String[] strings, List<List<String>> expected) {
        assertThat(p249.groupStringsV3(strings))
                .hasSize(expected.size())
                .containsAll(expected);
    }
}
