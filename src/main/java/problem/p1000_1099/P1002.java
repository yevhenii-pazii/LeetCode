package problem.p1000_1099;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P1002 {

    public List<String> commonChars(String[] words) {
        return null;
    }

    /*
        Time Complexity O(N) 44.31%
        Space Complexity O(N) 80.16%
     */
    public List<String> commonCharsCounting(String[] words) {
        int[][] counts = new int['z' - 'a' + 1][words.length];

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                counts[words[i].charAt(j) - 'a'][i]++;
            }
        }

        List<String> result = new ArrayList<>();
        MAIN:
        for (int i = 0; i < counts.length; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 0; j < counts[i].length; j++) {
                if (counts[i][j] == 0) {
                    continue MAIN;
                } else {
                    count = Math.min(count, counts[i][j]);
                }
            }

            String letter = (char) ('a' + i) + "";
            for (int k = 0; k < count; k++) {
                result.add(letter);
            }
        }

        return result;
    }

    /*
        Time Complexity O(N) 30.24%
        Space Complexity O(N) 37.64%
    */
    public List<String> commonCharsHashSet(String[] words) {
        Map<Character, Integer> base = new HashMap<>();
        String word = words[0];
        for (int i = 0; i < word.length(); i++) {
            base.compute(word.charAt(i), (k, v) -> v == null ? 1: v + 1);
        }

        for (int i = 1; i < words.length; i++) {
            Map<Character, Integer> newBase = new HashMap<>();
            word = words[i];
            for (int j = 0; j < word.length(); j++) {
                if (base.containsKey(word.charAt(j))) {
                    newBase.compute(word.charAt(j), (k, v) -> v == null ? 1 : v + 1);
                }
            }

            for (var key : newBase.keySet()) {
                newBase.put(key, Math.min(base.get(key), newBase.get(key)));
            }
            base = newBase;
        }

        List<String> result = new ArrayList<>();
        for (var entry : base.entrySet()) {
            String c = entry.getKey() + "";
            for (int j = entry.getValue(); j > 0; j--) {
                result.add(c);
            }
        }

        return result;
    }

}
