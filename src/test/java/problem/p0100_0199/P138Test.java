package problem.p0100_0199;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;
import static problem.p0100_0199.P138.Node.list;

class P138Test {

    private final P138 p138 = new P138();

    private static Stream<Arguments> data() {

        return Stream.of(
                of(list(new int[][]{
                        {7, -1}, {13, 0}, {11, 4}, {10, 2}, {1, 0}
                }))
        );
    }

    void validate(P138.Node input, P138.Node actual) {
        while (input != null) {
            assertThat(actual.val).isEqualTo(input.val);
            assertThat(actual).isNotSameAs(input);
            if (input.random == null) {
                assertThat(actual.random).isNull();
            } else {
                assertThat(actual.random.val).isEqualTo(input.random.val);
                assertThat(actual.random).isNotSameAs(input.random);
            }

            actual = actual.next;
            input = input.next;
        }
        assertThat(actual).isNull();
    }

    @ParameterizedTest
    @MethodSource("data")
    void copyRandomList(P138.Node input) {
        validate(input, p138.copyRandomList(input));
    }

    @ParameterizedTest
    @MethodSource("data")
    void copyRandomListV2(P138.Node input) {
        validate(input, p138.copyRandomListV2(input));
    }

    @ParameterizedTest
    @MethodSource("data")
    void copyRandomListV3(P138.Node input) {
        validate(input, p138.copyRandomListV3(input));
    }
}
