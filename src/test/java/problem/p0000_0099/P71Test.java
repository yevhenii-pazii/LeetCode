package problem.p0000_0099;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P71Test {

    private final P71 p71 = new P71();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments("/home/", "/home"),
                arguments("/../", "/"),
                arguments("/home//foo/", "/home/foo"),
                arguments("/a/./b/../../c/", "/c")
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void simplifyPath(String path, String expected) {
        assertThat(p71.simplifyPath(path)).isEqualTo(expected);
    }
}
