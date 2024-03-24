package problem.p0000_0099;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P69Test {

    private final P69 p69 = new P69();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(4, 2),
                arguments(8, 2),
                arguments(Integer.MAX_VALUE, 46340)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void mySqrt(int x, int expected) {
        assertThat(p69.mySqrt(x)).isEqualTo(expected);
    }
}
