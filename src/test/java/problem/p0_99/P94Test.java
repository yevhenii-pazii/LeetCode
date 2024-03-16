package problem.p0_99;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.TreeNode.node;

public class P94Test {

    private final P94 p94 = new P94();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(node(1, null, node(2, node(3), null)), new Integer[]{1, 3, 2}),
                arguments(null, new Integer[]{}),
                arguments(node(1), new Integer[]{1}),
                arguments(
                        node(1, node(2, node(4), node(5)), node(3, node(6), node(7))),
                        new Integer[]{4, 2, 5, 1, 6, 3, 7})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void inorderTraversalRecursion(TreeNode root, Integer[] expected) {
        Assertions.assertThat(p94.inorderTraversalRecursion(root)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void inorderTraversalStack(TreeNode root, Integer[] expected) {
        Assertions.assertThat(p94.inorderTraversalStack(root)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void inorderTraversalStackV2(TreeNode root, Integer[] expected) {
        Assertions.assertThat(p94.inorderTraversalStackV2(root)).containsExactlyInAnyOrder(expected);
    }
}
