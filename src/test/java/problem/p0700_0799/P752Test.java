package problem.p0700_0799;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P752Test {

    private final P752 p752 = new P752();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202", 6),
                arguments(new String[]{"8888"}, "0009", 1),
                arguments(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888", -1),
                arguments(new String[]{"0000"}, "8888", -1)

        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void openLock(String[] deadends, String target, int expected) {
        assertThat(p752.openLock(deadends, target)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void openLockV2(String[] deadends, String target, int expected) {
        assertThat(p752.openLockV2(deadends, target)).isEqualTo(expected);
    }
}
