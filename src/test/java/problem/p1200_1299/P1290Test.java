package problem.p1200_1299;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.ListNode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.ListNode.list;

class P1290Test {

    private final P1290 p1290 = new P1290();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(list(1, 0, 1), 5),
            arguments(list(0), 0)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void getDecimalValue(ListNode head, int result) {
        assertThat(p1290.getDecimalValue(head)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void getDecimalValueBit(ListNode head, int result) {
        assertThat(p1290.getDecimalValueBit(head)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void getDecimalValueBinary(ListNode head, int result) {
        assertThat(p1290.getDecimalValueBinary(head)).isEqualTo(result);
    }

}