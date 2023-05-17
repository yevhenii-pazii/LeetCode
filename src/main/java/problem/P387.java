package problem;

import java.util.HashMap;
import java.util.Map;

public class P387 {

    /*
        TODO implement
     */
    public int firstUniqCharBruteForce(String s) {
        return 0;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1) since there will be max 26 entries
     */
    public int firstUniqCharMap(String s) {
        Map<Character, Integer> map = new HashMap<>('z' - 'a' + 1);

        for (var i = 0; i < s.length(); i++) {
            map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }

        for (var i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1) since there will be max 26 entries
     */
    public int firstUniqCharArray(String s) {
        var array = new int['z' - 'a' + 1];

        for (var i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
        }

        for (var i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
