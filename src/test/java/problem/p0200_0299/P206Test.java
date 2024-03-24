package problem.p0200_0299;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.ListNode;

import java.util.Comparator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;
import static structure.ListNode.list;
import static structure.ListNode.node;

class P206Test {

    private final P206 p206 = new P206();

    private static Stream<Arguments> data() {
        return Stream.of(
                of(list(1, 2), list(2, 1)),
                of(node(1), node(1)),
                of(list(1, 2, 3, 4, 5), list(5, 4, 3, 2, 1)),
                of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void reverseList(ListNode original, ListNode result) {
        var actual = p206.reverseList(original);
        while (actual != null) {
            assertThat(actual).usingComparator(Comparator.comparingInt(n -> n.val)).isEqualTo(result);
            actual = actual.next;
            result = result.next;
        }
        assertThat(result).isNull();
    }

    @ParameterizedTest
    @MethodSource("data")
    void reverseListLoop(ListNode original, ListNode result) {
        var actual = p206.reverseListLoop(original);
        while (actual != null) {
            assertThat(actual).usingComparator(Comparator.comparingInt(n -> n.val)).isEqualTo(result);
            actual = actual.next;
            result = result.next;
        }
        assertThat(result).isNull();
    }

    @ParameterizedTest
    @MethodSource("data")
    void reverseListOfficial(ListNode original, ListNode result) {
        var actual = p206.reverseListOfficial(original);
        while (actual != null) {
            assertThat(actual).usingComparator(Comparator.comparingInt(n -> n.val)).isEqualTo(result);
            actual = actual.next;
            result = result.next;
        }
        assertThat(result).isNull();
    }
}
