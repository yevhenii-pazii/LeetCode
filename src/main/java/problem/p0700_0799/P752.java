package problem.p0700_0799;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

class P752 {

    /*
        Time Complexity O(N * N * A ^ N + D)
        Space Complexity O(A ^ N + D)

        A - is the number of digits in our alphabet
     */
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for (var s : deadends) {
            visited.add(s);
        }

        var moves = 0;

        Queue<String> queue = new ArrayDeque<>();
        queue.add("0000");

        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var b = 0; b < size; b++) {
                var current = queue.remove();
                if (target.equals(current)) return moves;

                if (!visited.contains(current)) {
                    var builder = new StringBuilder(current);
                    // work
                    for (var i = 0; i < 4; i++) {
                        var c = builder.charAt(i);

                        builder.setCharAt(i, c == '9' ? '0' : (char)(c + 1));
                        queue.add(builder.toString());
                        builder.setCharAt(i, c == '0' ? '9' : (char)(c - 1));
                        queue.add(builder.toString());

                        builder.setCharAt(i, c);
                    }


                    visited.add(current);
                }
            }
            moves++;
        }

        return -1;
    }
}
