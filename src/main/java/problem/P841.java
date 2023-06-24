package problem;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class P841 {

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        Queue<Integer> queue = new ArrayDeque<>(rooms.get(0));
        visited[0] = true;

        while (!queue.isEmpty()) {
            int r = queue.remove();
            if (!visited[r]) {
                visited[r] = true;

                for (var nr: rooms.get(r)) {
                    if (!visited[nr]) {
                        queue.add(nr);
                    }
                }
            }
        }

        for (var v : visited) {
            if (!v) return false;
        }
        return true;
    }
}
