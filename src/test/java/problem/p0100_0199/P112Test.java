package problem.p0100_0199;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.TreeNode.tree;

class P112Test {

    private final P112 p112 = new P112();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(tree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1), 22, true),
            arguments(tree(1, 2, 3), 5, false),
            arguments(null, 0, false),
            arguments(tree(1, 2), 1, false)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void hasPathSum(TreeNode root, int targetSum, boolean result) {
        assertThat(p112.hasPathSum(root, targetSum)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void hasPathSumRecursion(TreeNode root, int targetSum, boolean result) {
        assertThat(p112.hasPathSumRecursion(root, targetSum)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void hasPathSumDepthFirst(TreeNode root, int targetSum, boolean result) {
        assertThat(p112.hasPathSumDepthFirst(root, targetSum)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void hasPathSumBreadthFirst(TreeNode root, int targetSum, boolean result) {
        assertThat(p112.hasPathSumBreadthFirst(root, targetSum)).isEqualTo(result);
    }

}
