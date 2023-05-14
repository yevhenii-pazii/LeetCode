package problem;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class P599Test {

    private final P599 p599 = new P599();

    private static Stream<Arguments> data() {
        return Stream.of(
                arguments(
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"},
                        new String[]{"Shogun"}),
                arguments(
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"},
                        new String[]{"Shogun"}),
                arguments(
                        new String[]{"happy", "sad", "good"},
                        new String[]{"sad", "happy", "good"},
                        new String[]{"sad", "happy"})
        );
    }

    @ParameterizedTest
    @MethodSource("data")
    void findRestaurantTwoMaps(String[] list1, String[] list2, String[] expected) {
        assertThat(p599.findRestaurantTwoMaps(list1, list2)).containsExactlyInAnyOrder(expected);
    }

    @ParameterizedTest
    @MethodSource("data")
    void findRestaurantSingleMaps(String[] list1, String[] list2, String[] expected) {
        assertThat(p599.findRestaurantSingleMaps(list1, list2)).containsExactlyInAnyOrder(expected);
    }
}
