package problem.p0100_0199;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P101Test {

    private final P101 p101 = new P101();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(TreeNode.tree(1, 2, 2, 3, 4, 4, 3), true),
            arguments(TreeNode.tree(1, 2, 2, null, 3, null, 3), false),
            arguments(TreeNode.tree(2,3,3,4,null,5,4), false)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void isSymmetric(TreeNode root, boolean result) {
        assertThat(p101.isSymmetric(root)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isSymmetricRecursion(TreeNode root, boolean result) {
        assertThat(p101.isSymmetricRecursion(root)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isSymmetricDepthFirst(TreeNode root, boolean result) {
        assertThat(p101.isSymmetricDepthFirst(root)).isEqualTo(result);
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void isSymmetricBreadthFirst(TreeNode root, boolean result) {
        assertThat(p101.isSymmetricBreadthFirst(root)).isEqualTo(result);
    }

}
