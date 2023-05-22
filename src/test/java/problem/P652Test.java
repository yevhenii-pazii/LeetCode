package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.TreeNode.node;

public class P652Test {

    private final P652 p652 = new P652();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(node(1, node(2, node(4), null), node(3, node(2, node(4), null), node(4))),
                        List.of(node(2, node(4), null), node(4))),
                arguments(node(1, node(1, node(1), null), node(1, null, node(1))),
                        List.of(node(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void findDuplicateSubtrees(TreeNode root, List<TreeNode> expected) {
        assertThat(p652.findDuplicateSubtrees(root))
                .hasSize(expected.size())
                .containsAll(expected);
    }
}
