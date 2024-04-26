package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.TreeNode.node;

class P1372Test {

    private final P1372 p1372 = new P1372();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(node(1, null, node(2, node(3), node(4, node(5, null, node(7, null, node(8))), node(6)))), 3),
                arguments(node(1, node(2, null, node(4, node(5, null, node(7)), node(6))), node(3)), 4),
                arguments(node(1), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void longestZigZagPureRecursion(TreeNode root, int expected) {
        assertThat(p1372.longestZigZagPureRecursion(root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void longestZigZagRecursionWithMemo(TreeNode root, int expected) {
        assertThat(p1372.longestZigZagRecursionWithMemo(root)).isEqualTo(expected);
    }

}
