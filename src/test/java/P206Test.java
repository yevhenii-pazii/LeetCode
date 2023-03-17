import org.assertj.core.api.recursive.assertion.RecursiveAssertionConfiguration;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.stream.Stream;

//import static com.google.common.truth.Truth.assertThat;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.of;

class P206Test {

    private final P206 p206 = new P206();

    private static P206.ListNode node(int value) {
        return new P206.ListNode(value);
    }

    private static P206.ListNode node(int value, P206.ListNode next) {
        return new P206.ListNode(value, next);
    }

    private static Stream<Arguments> reverseList() {
        return Stream.of(
                of(node(1, node(2)), node(2, node(1))),
                of(node(1), node(1)),
                of(
                        node(1, node(2, node(3, node(4, node(5))))),
                        node(5, node(4, node(3, node(2, node(1)))))),
                of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource
    void reverseList(P206.ListNode original, P206.ListNode result) {
        var actual = p206.reverseList(original);
        while (actual != null) {
            assertThat(actual).usingComparator(Comparator.comparingInt(n -> n.val)).isEqualTo(result);
            actual = actual.next;
            result = result.next;
        }
        assertThat(result).isNull();
    }

    @ParameterizedTest
    @MethodSource("reverseList")
    void reverseListLoop(P206.ListNode original, P206.ListNode result) {
        var actual = p206.reverseListLoop(original);
        while (actual != null) {
            assertThat(actual).usingComparator(Comparator.comparingInt(n -> n.val)).isEqualTo(result);
            actual = actual.next;
            result = result.next;
        }
        assertThat(result).isNull();
    }

    @ParameterizedTest
    @MethodSource("reverseList")
    void reverseListOfficial(P206.ListNode original, P206.ListNode result) {
        var actual = p206.reverseListOfficial(original);
        while (actual != null) {
            assertThat(actual).usingComparator(Comparator.comparingInt(n -> n.val)).isEqualTo(result);
            actual = actual.next;
            result = result.next;
        }
        assertThat(result).isNull();
    }
}
