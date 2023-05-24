package problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P3 {

    // TODO add brute force solution

    /*
        Time Complexity O(2 * N)
        Space Complexity O(min (N, M))

        M - size of the charset/alphabet
     */
    public int lengthOfLongestSubstringMap(String s) {
        Map<Character, Boolean> characters = new HashMap<>();
        var longest = 0;
        var currentLength = 0;
        var start = 0;
        for (var end = 0; end < s.length(); end++) {
            var c = s.charAt(end);

            if (characters.getOrDefault(c, Boolean.FALSE)) {
                longest = Math.max(longest, currentLength);

                while (characters.getOrDefault(c, Boolean.FALSE)) {
                    currentLength--;
                    characters.put(s.charAt(start++), Boolean.FALSE);
                }

            }

            currentLength++;
            characters.put(c, Boolean.TRUE);

        }
        longest = Math.max(longest, currentLength);

        return longest;
    }

    /*
        Time Complexity O(2 * N)
        Space Complexity O(min (N, M))

        M - size of the charset/alphabet
     */
    public int lengthOfLongestSubstringArray(String s) {
        boolean[] chars = new boolean[127 - ' '];
        var longest = 0;
        var currentLength = 0;
        var start = 0;
        for (var end = 0; end < s.length(); end++) {
            var c = s.charAt(end);

            if (chars[c - ' ']) {
                longest = Math.max(longest, currentLength);

                while (chars[c - ' ']) {
                    currentLength--;
                    chars[s.charAt(start++) - ' '] = false;
                }
            }

            currentLength++;
            chars[c - ' '] = true;

        }
        longest = Math.max(longest, currentLength);

        return longest;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(min (N, M))

        M - size of the charset/alphabet
    */
    public int lengthOfLongestSubstringMapIndex(String s) {
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        var longest = 0;
        var start = 0;
        for (var end = 0; end < s.length(); end++) {
            var c = s.charAt(end);

            if (lastOccurrence.containsKey(c)) {
                start = lastOccurrence.get(c) + 1;
            }
            lastOccurrence.put(c, end);

            longest = Math.max(longest, end - start + 1);
        }

        return longest;
    }


    /*
    Time Complexity O(N)
    Space Complexity O(min (N, M))

    M - size of the charset/alphabet
*/
    public int lengthOfLongestSubstringArrayIndex(String s) {
        int[] lastOccurrence = new int[127 - ' '];
        Arrays.fill(lastOccurrence, -1);
        var longest = 0;
        var start = 0;
        for (var end = 0; end < s.length(); end++) {
            var c = s.charAt(end) - ' ';

            if (lastOccurrence[c] != -1) {
                start = lastOccurrence[c] + 1;
            }
            lastOccurrence[c] = end;

            longest = Math.max(longest, end - start + 1);
        }

        return longest;
    }
}
