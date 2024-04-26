package problem.p0700_0799;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import java.util.Comparator;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.TreeNode.node;
import static structure.TreeNode.tree;

class P700Test {

    private final P700 p700 = new P700();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(tree(4, 2, 7, 1, 3), 2, node(2)),
                arguments(tree(4, 2, 7, 1, 3), 5, null)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void searchBST(TreeNode root, int search, TreeNode expected) {
        if (expected == null) { // TODO doesn't like it need to find better way
            assertThat(p700.searchBST(root, search)).isEqualTo(expected);
        } else {
            assertThat(p700.searchBST(root, search))
                    .usingComparator(Comparator.comparingInt(TreeNode::getVal))
                    .isEqualTo(expected);
        }
    }

    @ParameterizedTest
    @MethodSource("data")
    void searchBSTLoop(TreeNode root, int search, TreeNode expected) {
        if (expected == null) { // TODO doesn't like it need to find better way
            assertThat(p700.searchBSTLoop(root, search)).isEqualTo(expected);
        } else {
            assertThat(p700.searchBST(root, search))
                    .usingComparator(Comparator.comparingInt(TreeNode::getVal))
                    .isEqualTo(expected);
        }
    }
}
