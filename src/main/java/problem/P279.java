package problem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class P279 {

    //TODO other solutions: DP, brute force, Greedy

    /*
        BFS

        Time Complexity O(?) complicated to determine
        Space Complexity O(?) complicated to determine
     */
    public int numSquaresQueue(int n) {
        List<Integer> perfects = new ArrayList<>();

        var pow = 1;
        for (var i = 1; (pow = i * i) <= n; i++) {
            perfects.add(pow);
        }

        Set<Integer> visited = new HashSet<>();
        var num = 1;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);

        while (!queue.isEmpty()) {
            var size = queue.size();

            for (var b = 0; b < size; b++) {
                var current = queue.remove();

                for (var p : perfects) {
                    var dif = current - p;
                    if (dif == 0) {
                        return num;
                    } else if (dif > 0 && !visited.contains(dif)) {
                        queue.add(dif);
                        visited.add(dif);
                    }
                }
            }
            num++;
        }


        return num; //should be unreleasable
    }
}
