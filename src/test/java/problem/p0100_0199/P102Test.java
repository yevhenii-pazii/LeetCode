package problem.p0100_0199;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P102Test {

    private final P102 p102 = new P102();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(TreeNode.tree(3, 9, 20, null, null, 15, 7), of(of(3), of(9, 20), of(15, 7))),
            arguments(TreeNode.tree(1), of(of(1))),
            arguments(null, of())
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void levelOrder(TreeNode root, List<List<Integer>> result) {
        assertThat(p102.levelOrder(root)).containsExactlyElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void levelOrderRecursion(TreeNode root, List<List<Integer>> result) {
        assertThat(p102.levelOrderRecursion(root)).containsExactlyElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void levelOrderFlat(TreeNode root, List<List<Integer>> result) {
        assertThat(p102.levelOrderFlat(root)).containsExactlyElementsOf(result);
    }

}
