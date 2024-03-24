package problem.p0100_0199;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.ListNode.list;

class P143Test {

    private P143 p143 = new P143();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(list(1, 2, 3, 4), list(1, 4, 2, 3)),
                arguments(list(1, 2, 3, 4, 5), list(1, 5, 2, 4, 3))
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void reorderList(ListNode head, ListNode result) {
        p143.reorderList(head);
        Assertions.assertThat(head).isEqualTo(result);
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void reorderListRecursion(ListNode head, ListNode result) {
        p143.reorderListRecursion(head);
        Assertions.assertThat(head).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void reorderListStack(ListNode head, ListNode result) {
        p143.reorderListStack(head);
        Assertions.assertThat(head).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void reorderListSlowFast(ListNode head, ListNode result) {
        p143.reorderListSlowFast(head);
        Assertions.assertThat(head).isEqualTo(result);
    }


}