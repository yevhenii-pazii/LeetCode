package problem.p2300_2399;

import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class P2370Test {

    private final P2370 p2370 = new P2370();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments("acfgbd", 2, 4),
            arguments("zabc", 2, 3),
            arguments("abcd", 3, 4)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void longestIdealString(String s, int k, int result) {
        Assertions.assertThat(p2370.longestIdealString(s, k)).isEqualTo(result);
    }

}