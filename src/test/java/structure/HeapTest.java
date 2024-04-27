package structure;

import java.util.stream.Stream;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class HeapTest {

    private static Stream<Arguments> testHeapifyDuringConstruction() {
        return Stream.of( //TODO more test cases
            arguments(new int[]{12, 9, 10, 6, 4, 5, 3}, new int[]{7, 3, 4, 5, 6, 9, 12, 10})
        );
    }

    @ParameterizedTest
    @MethodSource
    void testHeapifyDuringConstruction(int[] input, int[] expected) {
        assertThat(new Heap(input))
            .extracting("heap", as(InstanceOfAssertFactories.INT_ARRAY))
            .isEqualTo(expected);
    }

    //TODO test other methods

}