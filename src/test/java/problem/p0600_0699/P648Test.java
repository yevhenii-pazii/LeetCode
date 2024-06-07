package problem.p0600_0699;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P648Test {

    private final P648 p648 = new P648();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(List.of("cat", "bat", "rat"), "the cattle was rattled by the battery", "the cat was rat by the bat"),
            arguments(List.of("a", "b", "c"), "aadsfasf absbs bbab cadsfafs", "a a b c")
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void replaceWords(List<String> dictionary, String sentence, String result) {
        assertThat(p648.replaceWords(dictionary, sentence)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void replaceWordsTrie(List<String> dictionary, String sentence, String result) {
        assertThat(p648.replaceWordsTrie(dictionary, sentence)).isEqualTo(result);
    }

}
