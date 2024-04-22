package problem.p0700_0799;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class P705Test {

    @Test
    void myHashSetBasicOperations() {
        var hashSet = new P705.MyHashSet();
        assertThat(hashSet.contains(1)).isFalse();

        hashSet.add(1);
        assertThat(hashSet.contains(1)).isTrue();

        hashSet.remove(1);
        assertThat(hashSet.contains(1)).isFalse();
    }

    @Test
    void myHashSetAddTwice() {
        var hashSet = new P705.MyHashSet();
        hashSet.add(1);
        assertThat(hashSet.contains(1)).isTrue();

        hashSet.add(1);
        hashSet.remove(1);
        assertThat(hashSet.contains(1)).isFalse();
    }
}
