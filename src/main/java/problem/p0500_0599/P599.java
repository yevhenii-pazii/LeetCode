package problem.p0500_0599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P599 {

    /*
        Time Complexity O(l1 + l2 + l2) ~ O(N)
        Space Complexity O(l1 + l2 + R) ~ O(N + R)
        R - result
     */
    public String[] findRestaurantTwoMaps(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (var i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        Map<String, Integer> map2 = new HashMap<>();
        for (var i = 0; i < list2.length; i++) {
            map2.put(list2[i], i);
        }

        var list = list1.length < list2.length ? list1 : list2;
        var min = Integer.MAX_VALUE;
        Map<Integer, List<String>> result = new HashMap<>();
        for (String word : list) {
            if (map1.containsKey(word) && map2.containsKey(word)) {
                var sum = map1.get(word) + map2.get(word);
                if (sum <= min) {
                    min = sum;
                    result.computeIfAbsent(sum, s -> new ArrayList<>()).add(word);
                }
            }

        }

        return result.get(min).toArray(new String[0]);
    }

    /*
        Time Complexity O(l1 + l2) ~ O(N)
        Space Complexity O(l1 + R)
    */
    public String[] findRestaurantSingleMaps(String[] list1, String[] list2) {
        Map<String, Integer> map1 = new HashMap<>();
        for (var i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }

        List<String> result = new ArrayList<>();
        var min = Integer.MAX_VALUE;
        for (var i = 0; i < list2.length; i++) {
            var word = list2[i];
            if (map1.containsKey(word)) {
                var sum = i + map1.get(word);

                if (min == sum) {
                    result.add(word);
                } else if (sum < min) {
                    result.clear();
                    min = sum;
                    result.add(word);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}
