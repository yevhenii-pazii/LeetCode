package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P2405Test {
    private final P2405 p2405 = new P2405();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("abacaba", 4),
                arguments("ssssss", 6),
                arguments("z", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void partitionString(String input, int expected) {
        assertThat(p2405.partitionString(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void partitionStringLastSeen(String input, int expected) {
        assertThat(p2405.partitionStringLastSeen(input)).isEqualTo(expected);
    }
}
