package problem;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class P2336Test {

    @Test
    void smallestInfiniteSet() {
        var set = new P2336.SmallestInfiniteSet();
        set.addBack(2);
        assertThat(set.popSmallest()).isEqualTo(1);
        assertThat(set.popSmallest()).isEqualTo(2);
        assertThat(set.popSmallest()).isEqualTo(3);
        set.addBack(1);
        set.addBack(1);
        assertThat(set.popSmallest()).isEqualTo(1);
        assertThat(set.popSmallest()).isEqualTo(4);
        assertThat(set.popSmallest()).isEqualTo(5);
    }
}
