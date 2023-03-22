package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;
import static problem.P430.Node.find;
import static problem.P430.Node.list;
import static problem.P430.Node.node;

public class P430Test {

    private final P430 p430 = new P430();

    private static Stream<Arguments> data() {
        var l1 = list(1, 2, 3, 4, 5, 6);
        var l2 = list(7, 8, 9, 10);
        var l3 = list(11, 12);
        find(8, l2).child = l3;
        find(3, l1).child = l2;


        return Stream.of(
                of(null, null),
                of(node(1), node(1)),
                of(l1, list(1, 2, 3, 7, 8, 11, 12, 9, 10, 4, 5, 6)),
                of(node(1, null, null, node(2)), list(1, 2))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void flatten(P430.Node input, P430.Node expected) {
        assertThat(p430.flatten(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void flattenMyWithStack(P430.Node input, P430.Node expected) {
        assertThat(p430.flattenMyWithStack(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void flattenRecursion(P430.Node input, P430.Node expected) {
        assertThat(p430.flattenRecursion(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void flattenStack(P430.Node input, P430.Node expected) {
        assertThat(p430.flattenStack(input)).isEqualTo(expected);
    }
}
