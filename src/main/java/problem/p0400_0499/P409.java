package problem.p0400_0499;

import java.util.HashMap;
import java.util.Map;

class P409 {

    public int longestPalindrome(String s) {
        return 0;
    }

    /*
        Time Complexity O(N) 60.18%
        Space Complexity O(N) 59.67%
     */
    public int longestPalindromeHashMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        int result = 0;
        boolean middleCharacter = false;
        for (var entry : map.entrySet()) {
            if ((entry.getValue() & 1) == 1) { // odd
                if (middleCharacter) {
                    result += entry.getValue() - 1;
                } else {
                    middleCharacter = true;
                    result += entry.getValue();
                }
            } else {
                result += entry.getValue();
            }

        }

        return result;
    }

    /*
        Time Complexity O(N) 86.01%
        Space Complexity O(M) M >= N 90.37%
     */
    public int longestPalindromeArray(String s) {
        int[] counts = new int['z' - 'A' + 1];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'A']++;
        }

        int result = 0;
        boolean hadOdd = false;
        for (int count : counts) {
            if ((count & 1) == 1) {
                if (hadOdd) {
                    result += count - 1;
                } else {
                    hadOdd = true;
                    result += count;
                }
            } else {
                result += count;
            }
        }

        return result;
    }

    /*
        Time Complexity O(N) 86.01%
        Space Complexity O(M) M >= N 99.55%
     */
    public int longestPalindromeArrayOneLoop(String s) {
        int result = 0;
        int oddCount = 0;
        boolean[] memo = new boolean['z' - 'A' + 1];
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'A';
            if (memo[index]) {
                oddCount--;
                result += 2;
                memo[index] = false;
            } else {
                oddCount++;
                memo[index] = true;
            }

        }

        return oddCount == 0 ? result : result + 1;
    }

    /*
        Old implementations
     */

    public int longestPalindromeV1(String s) {
        var string = s.toCharArray();

        Map<Character, Integer> table = new HashMap<>();
        for (var c : string) {
            table.merge(c, 1, Integer::sum);
        }

        var length = 0;
        var oddAdded = false;
        for (var v : table.values()) {
            boolean isOdd = v % 2 == 1;
            length += v;
            if (isOdd) {
                if (oddAdded) {
                    length -= 1;
                } else {
                    oddAdded = true;
                }
            }
        }

        return length;
    }

    public int longestPalindromeV2(String s) {
        var string = s.toCharArray();

        var counts = new short['z' - 'A' + 1]; // letter range A-Z is 65-90 and a-z is 97-122 -> 122-65 = 57
        for (var c : string) {
            counts[c - 'A']++;
        }

        var length = 0;
        var oddAdded = false;
        for (var v : counts) {
            length += v;
            if (v % 2 == 1) {
                if (oddAdded) {
                    length -= 1;
                } else {
                    oddAdded = true;
                }
            }
        }

        return length;
    }

}
