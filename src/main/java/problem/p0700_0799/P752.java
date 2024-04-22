package problem.p0700_0799;

import java.util.*;

class P752 {

    /*
        Time Complexity O(N * N * A ^ N + D) O(4(d + 10^4)) 65%
        Space Complexity O(A ^ N + D) O(4(d + 10^4)) 55%

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

                        builder.setCharAt(i, c == '9' ? '0' : (char) (c + 1)); //could be replaced with map or array
                        queue.add(builder.toString());
                        builder.setCharAt(i, c == '0' ? '9' : (char) (c - 1));
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

    /*
        The same complexity, but should be faster because of array copy, but it is slower.
        TODO need to check why
        5%
        86%
     */
    public int openLockV2(String[] deadends, String target) {
        Comparator<char[]> comparator = (o1, o2) -> {
            // don't need to compare length
            for (int i = 0; i < 4; i++) {
                if (o1[i] != o2[i]) {
                    return o1[i] - o2[i];
                }
            }
            return 0;
        };

        var start = new char[]{'0', '0', '0', '0'};

        Set<char[]> visited = new TreeSet<>(comparator);
        for (var s : deadends) {
            visited.add(s.toCharArray());
        }
        if (visited.contains(start)) return -1;
        visited.add(start);


        Queue<char[]> queue = new ArrayDeque<>();
        queue.add(start);

        var targetArray = target.toCharArray();
        var moves = 0;

        while (!queue.isEmpty()) {
            var size = queue.size();
            for (int i = 0; i < size; i++) {
                var current = queue.remove();

                if (comparator.compare(current, targetArray) == 0) {
                    return moves;
                }

                for (var wheal = 0; wheal < 4; wheal++) {
                    var forward = current.clone();
                    forward[wheal] = forward[wheal] == '9' ? '0' : ++forward[wheal];
                    if (!visited.contains(forward)) {
                        queue.add(forward);
                        visited.add(forward);
                    }

                    var backward = current.clone();
                    backward[wheal] = backward[wheal] == '0' ? '9' : --backward[wheal];
                    if (!visited.contains(backward)) {
                        queue.add(backward);
                        visited.add(backward);
                    }
                }

            }
            moves++;
        }

        return -1;
    }
}
