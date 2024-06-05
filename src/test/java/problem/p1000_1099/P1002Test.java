package problem.p1000_1099;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1002Test {

    private final P1002 p1002 = new P1002();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new String[]{"bella", "label", "roller"}, List.of("e", "l", "l")),
            arguments(new String[]{"cool", "lock", "cook"}, List.of("c", "o"))
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void commonChars(String[] words, List<String> result) {
        assertThat(p1002.commonChars(words)).containsExactlyInAnyOrderElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void commonCharsCounting(String[] words, List<String> result) {
        assertThat(p1002.commonCharsCounting(words)).containsExactlyInAnyOrderElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void commonCharsHashSet(String[] words, List<String> result) {
        assertThat(p1002.commonCharsHashSet(words)).containsExactlyInAnyOrderElementsOf(result);
    }

}
