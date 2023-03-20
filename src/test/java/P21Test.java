import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

public class P21Test {

    private final P21 p21 = new P21();

    private static P21.ListNode n(int value) {
        return new P21.ListNode(value);
    }

    private static P21.ListNode n(int value, P21.ListNode next) {
        return new P21.ListNode(value, next);
    }

    private static Stream<Arguments> data() {
        return Stream.of(
                of(null, null, null),
                of(null, n(1), n(1)),
                of(n(1), null, n(1)),
                of(n(1), n(2), n(1, n(2))),
                of(n(2), n(1), n(1, n(2))),
                of(
                        n(1, n(2, n(4))),
                        n(1, n(3, n(4))),
                        n(1, n(1, n(2, n(3, n(4, n(4))))))
                )
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void mergeTwoLists(P21.ListNode input1, P21.ListNode input2, P21.ListNode result) {
        assertThat(p21.mergeTwoLists(input1, input2)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void mergeTwoListsLoop(P21.ListNode input1, P21.ListNode input2, P21.ListNode result) {
        assertThat(p21.mergeTwoListsLoop(input1, input2)).isEqualTo(result);
    }
}
