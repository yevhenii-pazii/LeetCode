package problem.p0600_0699;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.TreeNode.tree;

class P662Test {

    private final P662 p662 = new P662();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(tree(1, 3, 2, 5, 3, null, 9), 4),
                arguments(tree(1, 3, 2, 5, null, null, 9, 6, null, null, null, null, null, 7), 7),
                arguments(tree(1, 3, 2, 5), 2)
        );
    }

    //TODO FIX
    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void widthOfBinaryTree(TreeNode root, int expected) {
        assertThat(p662.widthOfBinaryTree(root)).isEqualTo(expected);
    }

    //TODO FIX
    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void widthOfBinaryTreeImproved(TreeNode root, int expected) {
        assertThat(p662.widthOfBinaryTreeImproved(root)).isEqualTo(expected);
    }
}
