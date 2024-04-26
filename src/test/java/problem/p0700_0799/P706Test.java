package problem.p0700_0799;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class P706Test {

    @Test
    void myHashMapBasicOperations() {
        var map = new P706.MyHashMap();

        assertThat(map.get(1)).isEqualTo(-1);
        map.remove(1);
        assertThat(map.get(1)).isEqualTo(-1);

        map.put(1, 10);
        assertThat(map.get(1)).isEqualTo(10);
        map.remove(1);
        assertThat(map.get(1)).isEqualTo(-1);
    }
}
