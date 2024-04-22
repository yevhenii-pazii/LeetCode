package problem.p0100_0199;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class P160Test {

    private final P160 solution = new P160();

    private static P160.ListNode node(int value, P160.ListNode node) {
        return new P160.ListNode(value, node);
    }

    private static P160.ListNode node(int value) {
        return new P160.ListNode(value);
    }

    private static Stream<Arguments> intersectionData() {
        var int1 = node(8, node(4, node(5)));

        return Stream.of(
                of(
                        node(4, node(1, int1)),
                        node(5, node(6, node(1, int1))),
                        int1
                ),
                of(
                        node(2, node(6, node(4))),
                        node(1, node(5)),
                        null
                ),
                of(
                        int1, int1, int1
                )
        );
    }

    @ParameterizedTest
    @MethodSource("intersectionData")
    void getIntersectionNode(P160.ListNode a, P160.ListNode b, P160.ListNode intersection) {
        assertThat(solution.getIntersectionNode(a, b)).isEqualTo(intersection);
    }

    @ParameterizedTest
    @MethodSource("intersectionData")
    void getIntersectionNodeV2(P160.ListNode a, P160.ListNode b, P160.ListNode intersection) {
        assertThat(solution.getIntersectionNodeV2(a, b)).isEqualTo(intersection);
    }

    @ParameterizedTest
    @MethodSource("intersectionData")
    void getIntersectionNodeV3(P160.ListNode a, P160.ListNode b, P160.ListNode intersection) {
        assertThat(solution.getIntersectionNodeV3(a, b)).isEqualTo(intersection);
    }
}
