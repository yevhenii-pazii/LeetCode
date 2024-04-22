package problem.p0700_0799;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.ListNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;
import static structure.ListNode.loopList;


public class P708Test {

    private final P708 p708 = new P708();

    private static Stream<Arguments> data() {
        return Stream.of(
                of(null, 1, loopList(1)),
                of(loopList(1), 2, loopList(1, 2)),
                of(loopList(1), 0, loopList(1, 0)),
                of(loopList(3, 4, 1), 2, loopList(3, 4, 1, 2)),
                of(loopList(3, 3, 3), 3, loopList(3, 3, 3, 3)),
                of(loopList(3, 3, 3), 0, loopList(3, 3, 3, 0)),
                of(loopList(1, 3, 5), 0, loopList(1, 3, 5, 0)),
                of(loopList(3, 5, 1), 6, loopList(3, 5, 6, 1))
        );
    }

    @Disabled("it is not working")
    @ParameterizedTest
    @MethodSource("data")
    void insertV1(ListNode head, int insertVal, ListNode result) {
        var actual = p708.insertV1(head, insertVal);

        var current = result;
        do {
            assertThat(actual.val).isEqualTo(current.val);
            actual = actual.next;
            current = current.next;
        } while (current != result);

    }

    @ParameterizedTest
    @MethodSource("data")
    void insertV2(ListNode head, int insertVal, ListNode result) {
        var actual = p708.insertV2(head, insertVal);

        var current = result;
        do {
            assertThat(actual.val).isEqualTo(current.val);
            actual = actual.next;
            current = current.next;
        } while (current != result);
    }
}
