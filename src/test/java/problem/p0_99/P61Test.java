package problem.p0_99;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.ListNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;
import static structure.ListNode.list;

public class P61Test {
    private final P61 p61 = new P61();

    private static Stream<Arguments> data() {
        return Stream.of(
                of(list(1, 2, 3, 4, 5), 1, list(5, 1, 2, 3, 4)),
                of(list(1, 2, 3, 4, 5), 2, list(4, 5, 1, 2, 3)),
                of(list(1, 2, 3), 0, list(1, 2, 3)),
                of(list(1, 2, 3), 3, list(1, 2, 3)),
                of(list(1, 2, 3), 4, list(3, 1, 2)),
                of(null, 7, null)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void rotateRight(ListNode input, int rotation, ListNode expected) {
        assertThat(p61.rotateRight(input, rotation)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void rotateRightV2(ListNode input, int rotation, ListNode expected) {
        assertThat(p61.rotateRightV2(input, rotation)).isEqualTo(expected);
    }
}
