package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static problem.P133.Node.graph;

public class P133Test {

    private final P133 p133 = new P133();

    private static Stream<Arguments> data() {
        return Stream.of(
                Arguments.arguments(
                        graph(
                                new int[]{1, 2, 4},
                                new int[]{2, 1, 3},
                                new int[]{3, 2, 4},
                                new int[]{4, 1, 3}
                        ),
                        graph(
                                new int[]{1, 2, 4},
                                new int[]{2, 1, 3},
                                new int[]{3, 2, 4},
                                new int[]{4, 1, 3}
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void cloneGraph(P133.Node input, P133.Node expected) {
        var result = p133.cloneGraph(input); //need to find a way how to test it out

        var i = 0;
    }

    @ParameterizedTest
    @MethodSource("data")
    void cloneGraphRecursion(P133.Node input, P133.Node expected) {
        var result = p133.cloneGraphRecursion(input); //need to find a way how to test it out

        var i = 0;
    }

}
