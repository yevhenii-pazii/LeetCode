import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.ListNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;
import static structure.ListNode.list;
import static structure.ListNode.node;

public class P2Test {

    private final P2 p2 = new P2();

    private static Stream<Arguments> data() {
        return Stream.of(
                of(null, null, null),
                of(node(0), node(0), node(0)),
                of(null, node(1), node(1)),
                of(node(1), null, node(1)),
                of(null, list(1, 2), list(1, 2)),
                of(list(1, 2), null, list(1, 2)),
                of(
                        list(2, 4, 3),
                        list(5, 6, 4),
                        list(7, 0, 8)
                ),
                of(
                        list(9, 9, 9, 9, 9, 9, 9),
                        list(9, 9, 9, 9),
                        list(8, 9, 9, 9, 0, 0, 0, 1)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void addTwoNumbers(ListNode l1, ListNode l2, ListNode result) {
        assertThat(p2.addTwoNumbers(l1, l2)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void addTwoNumbersRecursion(ListNode l1, ListNode l2, ListNode result) {
        assertThat(p2.addTwoNumbersRecursion(l1, l2)).isEqualTo(result);
    }

}
