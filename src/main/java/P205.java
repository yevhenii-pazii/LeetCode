import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class P205 {

    public boolean isIsomorphic(String s, String t) {
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

