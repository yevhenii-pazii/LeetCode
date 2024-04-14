package problem.p0400_0499;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.TreeNode.node;
import static structure.TreeNode.tree;

class P404Test {

    private final P404 p404 = new P404();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(node(3, node(9), node(20, node(15), node(7))), 24),
                arguments(node(1), 0),
                arguments(tree(0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8), 5)
        ).skip(2);
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void sumOfLeftLeaves(TreeNode root, int result) {
        assertThat(p404.sumOfLeftLeaves(root)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void sumOfLeftLeavesBreadthFirst(TreeNode root, int result) {
        assertThat(p404.sumOfLeftLeavesBreadthFirst(root)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void sumOfLeftLeavesDepth(TreeNode root, int result) {
        assertThat(p404.sumOfLeftLeavesDepth(root)).isEqualTo(result);
    }

}