package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Comparator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class P328Test {

    private final P328 p328 = new P328();

    private static P328.ListNode n(int value) {
        return new P328.ListNode(value);
    }

    private static P328.ListNode n(int value, P328.ListNode next) {
        return new P328.ListNode(value, next);
    }

    public static Stream<Arguments> oddEvenList() {
        return Stream.of(
                of(null, null),
                of(n(1, n(2)), n(1, n(2))),
                of(
                        n(1, n(2, n(3, n(4, n(5))))),
                        n(1, n(3, n(5, n(2, n(4)))))
                ),
                of(
                        n(2, n(1, n(3, n(5, n(6, n(4, n(7))))))),
                        n(2, n(3, n(6, n(7, n(1, n(5, n(4)))))))
                )
        );
    }


    @ParameterizedTest
    @MethodSource
    void oddEvenList(P328.ListNode input, P328.ListNode result) {
        var actual = p328.oddEvenList(input);
        while (actual != null) {
            assertThat(actual).usingComparator(Comparator.comparingInt(n -> n.val)).isEqualTo(result);
            actual = actual.next;
            result = result.next;
        }
        assertThat(result).isNull();
    }

    @ParameterizedTest
    @MethodSource("oddEvenList")
    void oddEvenListOfficial(P328.ListNode input, P328.ListNode result) {
        var actual = p328.oddEvenListOfficial(input);
        while (actual != null) {
            assertThat(actual).usingComparator(Comparator.comparingInt(n -> n.val)).isEqualTo(result);
            actual = actual.next;
            result = result.next;
        }
        assertThat(result).isNull();
    }
}
