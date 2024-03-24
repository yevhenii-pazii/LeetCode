package problem.p0200_0299;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

class P205 {

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public boolean isIsomorphicMap(String s, String t) {
        //Assume all checks for size and nullability
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (var i = 0; i < s.length(); i++) {
            var one = s.charAt(i);
            var two = t.charAt(i);
            if (Optional.ofNullable(map1.put(one, two)).orElse(two) != two
                    || Optional.ofNullable(map2.put(two, one)).orElse(one) != one) {
                return false;
            }
        }
        return true;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public boolean isIsomorphicArray(String s, String t) {
        var map1 = new char[256];
        var map2 = new char[256];

        for (var i = 0; i < s.length(); i++) {
            var c1 = s.charAt(i);
            var c2 = t.charAt(i);

            if (map1[c1] == '\0' && map2[c2] == '\0') {
                map1[c1] = c2;
                map2[c2] = c1;
            } else if (map1[c1] != c2 || map2[c2] != c1) {
                return false;
            }

        }

        return true;
    }
}


/* Official solution

    public boolean isIsomorphic(String s, String t) {

        int[] mappingDictStoT = new int[256];
        Arrays.fill(mappingDictStoT, -1);

        int[] mappingDictTtoS = new int[256];
        Arrays.fill(mappingDictTtoS, -1);

        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case 1: No mapping exists in either of the dictionaries
            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }

            // Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping exists and
            // it doesn't match in either of the dictionaries or both
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }

        return true;
    }
*/

