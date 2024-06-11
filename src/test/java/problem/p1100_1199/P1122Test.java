package problem.p1100_1199;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1122Test {

    private final P1122 p1122 = new P1122();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}, new int[]{2, 2, 2, 1, 4, 3, 3, 9, 6, 7, 19}),
            arguments(new int[]{28, 6, 22, 8, 44, 17}, new int[]{22, 28, 8, 6}, new int[]{22, 28, 8, 6, 17, 44})
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void relativeSortArray(int[] arr1, int[] arr2, int[] result) {
        assertThat(p1122.relativeSortArray(arr1, arr2)).containsExactly(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void relativeSortArrayCountingArray(int[] arr1, int[] arr2, int[] result) {
        assertThat(p1122.relativeSortArrayCountingArray(arr1, arr2)).containsExactly(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void relativeSortArrayCountingMap(int[] arr1, int[] arr2, int[] result) {
        assertThat(p1122.relativeSortArrayCountingMap(arr1, arr2)).containsExactly(result);
    }

}
