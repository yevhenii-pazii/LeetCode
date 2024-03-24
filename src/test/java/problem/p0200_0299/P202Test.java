package problem.p0200_0299;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P202Test {

    private final P202 p202 = new P202();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(19, true),
                arguments(2, false)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void isHappyHashSetForMemorization(int n, boolean expected) {
        assertThat(p202.isHappyHashSetForMemorization(n)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isHappyFastSlow(int n, boolean expected) {
        assertThat(p202.isHappyFastSlow(n)).isEqualTo(expected);
    }
}
