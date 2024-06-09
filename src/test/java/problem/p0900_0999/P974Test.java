package problem.p0900_0999;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P974Test {

    private final P974 p974 = new P974();

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new int[]{4, 5, 0, -2, -3, 1}, 5, 7),
            arguments(new int[]{5}, 9, 0)
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void subarraysDivByK(int[] nums, int k, int result) {
        assertThat(p974.subarraysDivByK(nums, k)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void subarraysDivByKPrefixSum(int[] nums, int k, int result) {
        assertThat(p974.subarraysDivByKPrefixSum(nums, k)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void subarraysDivByKPrefixSumInPlace(int[] nums, int k, int result) {
        assertThat(p974.subarraysDivByKPrefixSumInPlace(nums, k)).isEqualTo(result);
    }

    @ParameterizedTest
    @MethodSource("data")
    void subarraysDivByKPrefixSumInPlaceArray(int[] nums, int k, int result) {
        assertThat(p974.subarraysDivByKPrefixSumInPlaceArray(nums, k)).isEqualTo(result);
    }

}
