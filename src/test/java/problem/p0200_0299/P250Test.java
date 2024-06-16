package problem.p0200_0299;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P250Test {

    private final P250 p250 = new P250();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(TreeNode.tree(5, 1, 5, 5, 5, null, 5), 4),
            arguments(TreeNode.tree(5, 5, 5, 5, 5, null, 5), 6),
            arguments(null, 0)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void countUnivalSubtrees(TreeNode root, int result) {
        assertThat(p250.countUnivalSubtrees(root)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void countUnivalSubtreesRecursion(TreeNode root, int result) {
        assertThat(p250.countUnivalSubtreesRecursion(root)).isEqualTo(result);
    }

}
