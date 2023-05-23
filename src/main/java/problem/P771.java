package problem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P771 {

    /*
        Time Complexity O(J * S)
        Space Complexity O(1)
     */
    public int numJewelsInStonesBruteForce(String jewels, String stones) {
        var count = 0;

        MAIN: for (var i = 0; i < stones.length(); i++) {
            for (var j = 0; j < jewels.length(); j++) {
                if (stones.charAt(i) == jewels.charAt(j)) {
                    count++;
                    continue MAIN;
                }
            }
        }

        return count;
    }

    /*
        Time Complexity O(J + S)
        Space Complexity O(J)
     */
    public int numJewelsInStonesHashSet(String jewels, String stones) {
        Set<Character> j = new HashSet<>(jewels.length());
        for (var i = 0; i < jewels.length(); i++) {
            j.add(jewels.charAt(i));
        }

        var count = 0;
        for (var i = 0; i < stones.length(); i++) {
            if (j.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }


    /*
        Time Complexity O(J + S + R)
        Space Complexity O(J + S)

        R - retain time
     */
    public int numJewelsInStonesList(String jewels, String stones) {
        Set<Character> j = new HashSet<>(jewels.length());
        for (var i = 0; i < jewels.length(); i++) {
            j.add(jewels.charAt(i));
        }

        List<Character> s = new ArrayList<>(stones.length());
        for (var i = 0; i < stones.length(); i++) {
            s.add(stones.charAt(i));
        }

        s.retainAll(j);
        return s.size();
    }
}
