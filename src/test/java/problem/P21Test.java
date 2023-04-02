package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.ListNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;
import static structure.ListNode.list;
import static structure.ListNode.node;

public class P21Test {

    private final P21 p21 = new P21();

    private static Stream<Arguments> data() {
        return Stream.of(
                of(null, null, null),
                of(null, node(1), node(1)),
                of(node(1), null, node(1)),
                of(node(1), node(2), list(1, 2)),
                of(node(2), node(1), list(1, 2)),
                of(list(1, 2, 4), list(1, 3, 4), list(1, 1, 2, 3, 4, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void mergeTwoLists(ListNode input1, ListNode input2, ListNode result) {
        assertThat(p21.mergeTwoLists(input1, input2)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void mergeTwoListsLoop(ListNode input1, ListNode input2, ListNode result) {
        assertThat(p21.mergeTwoListsLoop(input1, input2)).isEqualTo(result);
    }
}
