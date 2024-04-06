package problem.p1200_1299;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P1249Test {

    private final P1249 p1249 = new P1249();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("lee(t(c)o)de)", Set.of("lee(t(c)o)de", "lee(t(co)de)", "lee(t(c)ode)")),
                arguments("a)b(c)d", Set.of("ab(c)d")),
                arguments("))((", Set.of("")),
                arguments("(l(e)e(t)", Set.of("l(e)e(t)", "(le)e(t)", "(l(e)et)"))
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void minRemoveToMakeValid(String s, Set<String> expected) {
        assertThat(p1249.minRemoveToMakeValid(s)).isIn(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void minRemoveToMakeValidPointers(String s, Set<String> expected) {
        assertThat(p1249.minRemoveToMakeValidPointers(s)).isIn(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void minRemoveToMakeValidStack(String s, Set<String> expected) {
        assertThat(p1249.minRemoveToMakeValidStack(s)).isIn(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void minRemoveToMakeValidTwoPass(String s, Set<String> expected) {
        assertThat(p1249.minRemoveToMakeValidTwoPass(s)).isIn(expected);
    }
}