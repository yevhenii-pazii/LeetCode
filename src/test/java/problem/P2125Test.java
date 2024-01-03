package problem;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P2125Test {

    private final P2125 p2125 = new P2125();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new String[] {"011001","000000","010100","001000"}, 8),
                arguments(new String[] {"000","111","000"}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void numberOfBeams(String[] bank, int result) {
        Assertions.assertThat(p2125.numberOfBeams(bank)).isEqualTo(result);
    }
}
