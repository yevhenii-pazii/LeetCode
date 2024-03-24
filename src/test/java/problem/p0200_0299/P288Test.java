package problem.p0200_0299;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P288Test {

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(new String[]{"deer", "door", "cake", "card"}, Map.of(
                        "dear", false,
                        "cart", true,
                        "cane", false,
                        "make", true,
                        "cake", true))
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void validWordAbbr(String[] dictionary, Map<String, Boolean> expected) {
        var validator = new P288.ValidWordAbbr(dictionary);

        for (var e : expected.entrySet()) {
            assertThat(validator.isUnique(e.getKey())).as(e.getKey()).isEqualTo(e.getValue());
        }
    }


    @ParameterizedTest
    @MethodSource("data")
    void validWordAbbrV2(String[] dictionary, Map<String, Boolean> expected) {
        var validator = new P288.ValidWordAbbrV2(dictionary);

        for (var e : expected.entrySet()) {
            assertThat(validator.isUnique(e.getKey())).as(e.getKey()).isEqualTo(e.getValue());
        }
    }
}
