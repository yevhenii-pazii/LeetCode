package problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class P2390 {

    /*
        Stack approach

        Time Complexity O(N)
        Space Complexity o(N)
     */
    public String removeStarsStack(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stack.remove();
            } else {
                stack.push(s.charAt(i));
            }
        }

        var chars = new char[stack.size()];
        for (var i = stack.size() - 1; i >= 0; i--) {
            chars[i] = stack.remove();
        }

        return new String(chars);
    }

    /*
        Two pointers

        Time Complexity O(N)
        Space Complexity O(N)

     */
    public String removeStarsArray(String s) {
        var result = new char[s.length()];
        var index = 0;

        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                index--;
            } else {
                result[index++] = s.charAt(i);
            }
        }

        return new String(result, 0, index);
    }

}
