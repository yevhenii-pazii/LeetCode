package problem.p0200_0299;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.of;

class P234Test {

    private final P234 p234 = new P234();

    private static P234.ListNode n(int value) {
        return new P234.ListNode(value);
    }

    private static P234.ListNode n(int value, P234.ListNode next) {
        return new P234.ListNode(value, next);
    }


    private static Stream<Arguments> data() {
        return Stream.of(
                of(n(1), true),
                of(null, false),
                of(n(1, n(2)), false),
                of(n(1, n(2, n(1))), true),
                of(n(1, n(2, n(3, n(3, n(2, n(1)))))), true)
        );
    }
    // TODO add verification that original list not broken

    @ParameterizedTest
    @MethodSource("data")
    void isPalindrome(P234.ListNode input, boolean palindrome) {
        assertThat(p234.isPalindrome(input)).isEqualTo(palindrome);
    }

    @ParameterizedTest
    @MethodSource("data")
    void isPalindromeNoExtraSpace(P234.ListNode input, boolean palindrome) {
        assertThat(p234.isPalindromeNoExtraSpace(input)).isEqualTo(palindrome);
    }
}
