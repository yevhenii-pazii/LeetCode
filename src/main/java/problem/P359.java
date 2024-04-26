package problem;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class P359 {

    /*
        TODO need to implement some solutions and tests
     */

    static class Logger {

        private final Map<Integer, Set<String>> storage = new HashMap<>();
        private int min = 0;

        public Logger() {

        }

        private boolean contains(int timestamp, String message) {
            for (var i = timestamp; i > timestamp - 10 && i >= min; i--) {
                if (storage.getOrDefault(i, Collections.emptySet()).contains(message)) {
                    return true;
                }
            }

            return false;
        }

        private void cleanUp(int newTimeStamp) {
            int newMin = Math.max(newTimeStamp - 10, min);

            for (var i = min; i < newMin; i++) {
                storage.remove(i);
            }

            min = newMin;
        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            if (!contains(timestamp, message)) {
                storage.computeIfAbsent(timestamp, k -> new HashSet<>());
                storage.get(timestamp).add(message);
                cleanUp(timestamp);

                return true;
            }

            return false;
        }
    }
}
