package problem.p0000_0099;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P14Test {

    private final P14 p14 = new P14();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new String[]{"flower","flow","flight"}, "fl"),
                arguments(new String[]{"dog","racecar","car"}, "")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void longestCommonPrefix(String[] strs, String expected) {
        assertThat(p14.longestCommonPrefix(strs)).isEqualTo(expected);
    }
}
