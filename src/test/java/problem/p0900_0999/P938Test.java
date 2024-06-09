package problem.p0900_0999;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.TreeNode.node;

class P938Test {

    private final P938 p938 = new P938();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(
                        node(10, node(5, node(3), node(7)), node(15, null, node(18))),
                        7, 15, 32)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void rangeSumBSTRecursion(TreeNode root, int low, int high, int result) {
        assertThat(p938.rangeSumBSTRecursion(root, low, high)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void rangeSumBSTIterative(TreeNode root, int low, int high, int result) {
        assertThat(p938.rangeSumBSTIterative(root, low, high)).isEqualTo(result);
    }
}
