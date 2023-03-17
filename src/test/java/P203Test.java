import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

public class P203Test {

    private final P203 p203 = new P203();

    private static P203.ListNode node(int value) {
        return new P203.ListNode(value);
    }

    private static P203.ListNode node(int value, P203.ListNode next) {
        return new P203.ListNode(value, next);
    }


    private static Stream<Arguments> removeElements() {
        return Stream.of(
                of(
                        node(1, node(6, node(3, node(4, node(5, node(6)))))),
                        6,
                        node(1, node(3, node(4, node(5))))
                ),
                of(null, 1, null),
                of(node(1, node(1, node(1))), 1, null)
        );
    }

    @ParameterizedTest
    @MethodSource
    void removeElements(P203.ListNode input, int remove, P203.ListNode result) {
        var actual = p203.removeElements(input, remove);
        while (actual != null) {
            assertThat(actual).usingComparator(Comparator.comparingInt(n -> n.val)).isEqualTo(result);
            actual = actual.next;
            result = result.next;
        }
        assertThat(result).isNull();
    }


    @ParameterizedTest
    @MethodSource("removeElements")
    void removeElementsRecursive(P203.ListNode input, int remove, P203.ListNode result) {
        var actual = p203.removeElementsRecursive(input, remove);
        while (actual != null) {
            assertThat(actual).usingComparator(Comparator.comparingInt(n -> n.val)).isEqualTo(result);
            actual = actual.next;
            result = result.next;
        }
        assertThat(result).isNull();
    }

    @ParameterizedTest
    @MethodSource("removeElements")
    void removeElementsRecursiveFromSolutions(P203.ListNode input, int remove, P203.ListNode result) {
        var actual = p203.removeElementsRecursiveFromSolutions(input, remove);
        while (actual != null) {
            assertThat(actual).usingComparator(Comparator.comparingInt(n -> n.val)).isEqualTo(result);
            actual = actual.next;
            result = result.next;
        }
        assertThat(result).isNull();
    }

}
