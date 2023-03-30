import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class P19Test {

    private final P19 p19 = new P19();

    private static P19.ListNode node(int value) {
        return new P19.ListNode(value);
    }

    private static P19.ListNode node(int value, P19.ListNode next) {
        return new P19.ListNode(value, next);
    }

    private static Stream<Arguments> removeNthFromEnd() {
        var node1 = node(1, node(2, node(3, node(4, node(5)))));
        var node2 = node(1, node(2, node(3, node(5))));

        return Stream.of(
                of(node1, 2, node2),
                of(node(1), 1, null),
                of(node(1, node(2)), 1, node(1))
        );
    }

    @ParameterizedTest
    @MethodSource
    void removeNthFromEnd(P19.ListNode head, int n, P19.ListNode result) {
        assertThat(p19.removeNthFromEnd(head, n)).isEqualTo(result); // I would want to have equals with comparator
    }
}
