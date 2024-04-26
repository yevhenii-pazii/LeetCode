package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P841Test {

    private final P841 p841 = new P841();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(of(of(1), of(2), of(3), of()), true),
                arguments(of(of(1, 3), of(3, 0, 1), of(2), of(0)), false)
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void canVisitAllRooms(List<List<Integer>> rooms, boolean expected) {
        assertThat(p841.canVisitAllRooms(rooms)).isEqualTo(expected);
    }
}
