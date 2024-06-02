package problem.p0300_0399;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class P380 {

    static class RandomizedSet {

        private final List<Integer> items = new ArrayList<>();
        private final Map<Integer, Integer> indexes = new HashMap<>();
        private final Random random = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (!indexes.containsKey(val)) {
                indexes.put(val, items.size());
                items.add(val);
                return true;
            }

            return false;
        }

        public boolean remove(int val) {
            if (! indexes.containsKey(val)) return false;


            int lastElement = items.get(items.size() - 1);
            int idx = indexes.get(val);
            items.set(idx, lastElement);
            indexes.put(lastElement, idx);
            items.remove(items.size() - 1);
            indexes.remove(val);
            return true;
        }

        public int getRandom() {
            return items.get(random.nextInt(0, items.size()));
        }
    }

}
