package problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class P71 {

    /*
        Time Complexity O(N)
        Space Complexity O(N)

        Works pretty fast as using String Builder for split and reuse existing builder
        for empty dir, same dir and parent dir
     */
    public String simplifyPath(String path) {
        Deque<StringBuilder> stack = new ArrayDeque<>();

        var index = 0;
        StringBuilder item = new StringBuilder();
        while (index < path.length()) {
            for (; index < path.length() && path.charAt(index) != '/'; index++) {
                item.append(path.charAt(index));
            }

            index++;

            if (item.isEmpty()) {
                continue;
            }

            if (item.length() == 1 && item.charAt(0) == '.') {
                item.deleteCharAt(0); //this saves a lot of space
                continue;
            }

            if (item.length() == 2 && item.charAt(0) == '.' && item.charAt(1) == '.') {
                stack.poll();
                item.deleteCharAt(1); //this saves a lot of space
                item.deleteCharAt(0);
                continue;
            }

            stack.push(item);
            item = new StringBuilder();
        }

        StringBuilder result = new StringBuilder(path.length());
        while (!stack.isEmpty()) {
            var dir = stack.removeLast();
            result.append('/');
            result.append(dir);
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}
