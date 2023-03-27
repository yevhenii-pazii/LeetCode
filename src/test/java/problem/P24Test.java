package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.ListNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.ListNode.list;

public class P24Test {

    private final P24 p24 = new P24();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(list(1, 2, 3, 4), list(2, 1, 4, 3)),
                arguments(null, null),
                arguments(list(1), list(1))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void swapPairs(ListNode input, ListNode expected) {
        assertThat(p24.swapPairs(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void swapPairsLoop(ListNode input, ListNode expected) {
        assertThat(p24.swapPairsLoop(input)).isEqualTo(expected);
    }
}
