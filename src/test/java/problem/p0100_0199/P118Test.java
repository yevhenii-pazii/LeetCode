package problem.p0100_0199;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P118Test {

    private final P118 p118 = new P118();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(5, new ArrayList<>(of(
                        new ArrayList<>(of(1)),
                        new ArrayList<>(of(1, 1)),
                        new ArrayList<>(of(1, 2, 1)),
                        new ArrayList<>(of(1, 3, 3, 1)),
                        new ArrayList<>(of(1, 4, 6, 4, 1)))))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void generate(int numRows, List<List<Integer>> expected) {
        assertThat(p118.generate(numRows)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void generateV2(int numRows, List<List<Integer>> expected) {
        assertThat(p118.generateV2(numRows)).isEqualTo(expected);
    }
}
