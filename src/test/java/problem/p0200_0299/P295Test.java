package problem.p0200_0299;

import java.util.stream.Stream;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class P295Test {

    private static Stream<Arguments> data() {
        return Stream.of(
            arguments(new Number[]{1, 2, 1.5, 3, 2.0}, new char[]{'a', 'a', 'f', 'a', 'f'})
        );
    }

    @Disabled
    @ParameterizedTest
    @MethodSource("data")
    void medianFinderDefault(Number[] numbers, char[] operations) {
        P295.Default.MedianFinder mf = new P295.Default.MedianFinder();

        for (int i = 0; i < numbers.length; i++) {
            if (operations[i] == 'a') {
                mf.addNum(numbers[i].intValue());
            } else {
                assertThat(mf.findMedian())
                    .as("Medial index is %s", i)
                    .isEqualTo(numbers[i].doubleValue());
            }
        }
    }

    @ParameterizedTest
    @MethodSource("data")
    void medianFinderTwoHeaps(Number[] numbers, char[] operations) {
        P295.TwoHeaps.MedianFinder mf = new P295.TwoHeaps.MedianFinder();

        for (int i = 0; i < numbers.length; i++) {
            if (operations[i] == 'a') {
                mf.addNum(numbers[i].intValue());
            } else {
                assertThat(mf.findMedian())
                    .as("Medial index is %s", i)
                    .isEqualTo(numbers[i].doubleValue());
            }
        }
    }

}
