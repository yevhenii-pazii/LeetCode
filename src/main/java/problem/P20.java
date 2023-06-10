package problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class P20 {

    /*
        Simplest solution
        Time Complexity O(N)
        Space Complexity O(N)
        N - size of the sting
     */
    public boolean isValidStack(String s) {
        if ((s.length() & 0x1) == 1) return false; // same as s.length() % 2 != 0

        Deque<Character> stack = new ArrayDeque<>(s.length() / 2); //play with length

        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char cOpen = stack.remove();
                if(!((c == ')' && cOpen == '(') || (c == ']' && cOpen == '[') || (c == '}' && cOpen == '{')))
                    return false;
            }

        }

        return stack.isEmpty();
    }

    /*
        Simplest solution
        Time Complexity O(N)
        Space Complexity O(N)
        N - size of the sting
     */
    public boolean isValidArray(String s) {
        if ((s.length() & 0x1) == 1) return false; // same as s.length() % 2 != 0

        char[] array = new char[s.length() / 2]; //play with length
        var index = 0;

        for (var i = 0; i < s.length(); i++) {
            var c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                if (index == array.length) return false;
                array[index++] = c;
            } else {
                if (index == 0) return false;
                var cOpen = array[--index];
                if(!((c == ')' && cOpen == '(') || (c == ']' && cOpen == '[') || (c == '}' && cOpen == '{')))
                    return false;
            }

        }

        return index == 0;
    }
}
