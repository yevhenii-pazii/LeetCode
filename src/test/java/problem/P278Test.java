package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P278Test {

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(5, 4),
                arguments(1, 1),
                arguments(Integer.MAX_VALUE, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void firstBadVersionBinarySearch(int n, int bad) {
        assertThat(new P278(bad).firstBadVersionBinarySearch(n)).isEqualTo(bad);
    }

    @ParameterizedTest
    @MethodSource("data")
    void firstBadVersionBinarySearchTemplate2(int n, int bad) {
        assertThat(new P278(bad).firstBadVersionBinarySearchTemplate2(n)).isEqualTo(bad);
    }
}
