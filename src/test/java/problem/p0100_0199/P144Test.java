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

class P144Test {

    private final P144 p144 = new P144();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(TreeNode.tree(1, null, 2, 3), List.of(1, 2, 3)),
            arguments(TreeNode.tree(1), List.of(1)),
            arguments(null, List.of())
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void preorderTraversal(TreeNode root, List<Integer> result) {
        assertThat(p144.preorderTraversal(root)).containsExactlyElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void preorderTraversalRecursion(TreeNode root, List<Integer> result) {
        assertThat(p144.preorderTraversalRecursion(root)).containsExactlyElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void preorderTraversalLoop(TreeNode root, List<Integer> result) {
        assertThat(p144.preorderTraversalLoop(root)).containsExactlyElementsOf(result);
    }

}
