package problem.p0100_0199;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P145Test {

    private final P145 p145 = new P145();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(TreeNode.tree(1, null, 2, 3), List.of(3, 2, 1)),
            arguments(null, List.of()),
            arguments(TreeNode.tree(1), List.of(1)),
            arguments(TreeNode.tree(3, 1, 2), List.of(1, 2, 3))
        ).skip(3);
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void postorderTraversal(TreeNode root, List<Integer> result) {
        assertThat(p145.postorderTraversal(root)).containsExactlyElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void postorderTraversalRecursion(TreeNode root, List<Integer> result) {
        assertThat(p145.postorderTraversalRecursion(root)).containsExactlyElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void postorderTraversalStack(TreeNode root, List<Integer> result) {
        assertThat(p145.postorderTraversalStack(root)).containsExactlyElementsOf(result);
    }

}
