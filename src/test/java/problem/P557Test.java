package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P557Test {
    private final P557 p557 = new P557();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc"),
                arguments("God Ding", "doG gniD")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void reverseWordsTwoPointers(String s, String expected) {
        assertThat(p557.reverseWordsTwoPointers(s)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void reverseWordsTraverseAndReplace(String s, String expected) {
        assertThat(p557.reverseWordsTraverseAndReplace(s)).isEqualTo(expected);
    }
}
