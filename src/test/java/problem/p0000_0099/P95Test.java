package problem.p0000_0099;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import structure.TreeNode;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static structure.TreeNode.tree;

class P95Test {

    private final P95 p95 = new P95();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(3, List.of(
                        tree(1, null, 2, null, 3),
                        tree(1, null, 3, 2),
                        tree(2, 1, 3),
                        tree(3, 1, null, null, 2),
                        tree(3, 2, null, 1)
                )),
                arguments(1, List.of(tree(1)))
        );
    }

    @Disabled("Fails to pass even for official, need to fix the TC")
    @ParameterizedTest
    @MethodSource("data")
    void generateTreesOfficial(int n, List<TreeNode> expected) {
        assertThat(p95.generateTreesOfficial(n))
                .hasSize(expected.size())
                .containsAll(expected);
    }
}
