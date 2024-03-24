package problem.p0200_0299;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.TreeNode.node;

class P270Test {

    private final P270 p270 = new P270();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(node(4, node(2, node(1), node(3)), node(5)), 3.714286, 4),
                arguments(node(1), 4.428571, 1),
                arguments(node(4, node(2, node(1), node(3)), node(5)), 3.5, 3),
                arguments(node(4, node(2, node(1), node(3)), node(5)), 4.5, 4),
                arguments(node(3, node(2, node(1), null), node(4)), 4.142857, 4),
                arguments(node(1, null, node(2)), 3.428571, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void closestValue(TreeNode root, double target, int expected) {
        assertThat(p270.closestValue(root, target)).isEqualTo(expected);
    }
}
