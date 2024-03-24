package problem.p0100_0199;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.TreeNode.tree;

class P104Test {

    private final P104 p104 = new P104();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(tree(3, 9, 20, null, null, 15, 7), 3),
                arguments(tree(3, 9, 20, null, null, 15, 7, null, null, null, null, 1), 4),
                arguments(tree(1), 1),
                arguments(null, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void maxDepthRecursion(TreeNode root, int expected) {
        assertThat(p104.maxDepthRecursion(root)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void maxDepthDepthFirst(TreeNode root, int expected) {
        assertThat(p104.maxDepthDepthFirst(root)).isEqualTo(expected);
    }


    @ParameterizedTest
    @MethodSource("data")
    void maxDepthBreadthFirst(TreeNode root, int expected) {
        assertThat(p104.maxDepthBreadthFirst(root)).isEqualTo(expected);
    }
}
