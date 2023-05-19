package problem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P49 {

    /*
        TODO Key can be computed somehow so no need to deal with arrays
     */

    /*
        Time Complexity O(N * K * Log K)
        Space Complexity O(N * K)

        K is the maximum length of a string in strs
     */
    public List<List<String>> groupAnagramsMapSortBased(String[] strs) {
        Map<char[], List<String>> groups = new TreeMap<>(Arrays::compare);

        for (var s : strs) {
            var charArray = s.toCharArray();
            Arrays.sort(charArray);
            groups.computeIfAbsent(charArray, k -> new ArrayList<>()).add(s);
        }

        List<List<String>> result = new ArrayList<>(groups.size());
        result.addAll(groups.values());

        return result;
    }

    /*
        Time Complexity O(N * K)
        Space Complexity O(N * K)

        K is the maximum length of a string in strs
     */
    public List<List<String>> groupAnagramsMapCountBased(String[] strs) {
        Map<int[], List<String>> groups = new TreeMap<>(Arrays::compare);

        for (var s : strs) {
            var key = new int['z' - 'a' + 1];
            for (var i = 0; i < s.length(); i++) {
                key[s.charAt(i) - 'a']++;
            }
            groups.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }


        List<List<String>> result = new ArrayList<>(groups.size());
        result.addAll(groups.values());

        return result;
    }
}
