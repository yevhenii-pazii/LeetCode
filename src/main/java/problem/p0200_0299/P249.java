package problem.p0200_0299;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P249 {

    /*
        Time Complexity O(N * K)
        Space Complexity O(N + k)
     */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> table = new HashMap<>();

        for (var s : strings) {
            var keyBuilder = new StringBuilder();
            for (var i = s.length() - 2; i >= 0; i--) {
                var c1 = s.charAt(i);
                var c2 = s.charAt(i + 1);

                if (c1 > c2) {
                    keyBuilder.append(26 - c1 + c2);
                } else {
                    keyBuilder.append(c2 - c1);
                }
                keyBuilder.append('/');
            }

            table.computeIfAbsent(keyBuilder.toString(), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(table.values());
    }

    /*
        Time Complexity O(N * K)
        Space Complexity O(N + k)
     */
    public List<List<String>> groupStringsV2(String[] strings) {
        Map<String, List<String>> table = new HashMap<>();

        for (var s : strings) {
            var keyBuilder = new StringBuilder();
            for (var i = s.length() - 2; i >= 0; i--) {
                keyBuilder.append((26 - s.charAt(i) + s.charAt(i + 1)) % 26);
                keyBuilder.append('/');
            }

            table.computeIfAbsent(keyBuilder.toString(), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(table.values());
    }

    /*
        Time Complexity O(N * K)
        Space Complexity O(N + k)

        Much faster and saves space
     */
    public List<List<String>> groupStringsV3(String[] strings) {
        Map<String, List<String>> table = new HashMap<>();

        for (var s : strings) {
            var keyBuilder = new StringBuilder(s.length());
            for (var i = s.length() - 2; i >= 0; i--) {
                keyBuilder.append((char) ((26 - s.charAt(i) + s.charAt(i + 1)) % 26 + 'a'));
            }

            table.computeIfAbsent(keyBuilder.toString(), k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(table.values());
    }
}
