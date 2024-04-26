package problem;

import java.util.ArrayDeque;
import java.util.Deque;

class P394 {

    /*
        Linear
     */
    public String decodeString(String s) {
        if (s.matches("\\d+")) return "";
        if (!s.contains("[")) return s;

        var builder = new StringBuilder();
        int start, end;
        for (start = 0; start < s.length(); start++) {
            var c = s.charAt(start);
            if ('a' <= c && c <= 'z') {
                builder.append(c);
            } else {
                break;
            }
        }

        for (end = start; end < s.length(); end++) {
            if (s.charAt(end) == '[') {
                break;
            }
        }

        int repeat = Integer.parseInt(s.substring(start, end));

        start = end + 1;
        int bracketCount = 0;
        for (end = start; end < s.length(); end++) {
            var c = s.charAt(end);
            if (c == '[') {
                bracketCount++;
                continue;
            }
            if (c == ']') {
                if (bracketCount == 0) {
                    break;
                } else {
                    bracketCount--;
                }
            }
        }


        var decodedInternal = decodeString(s.substring(start, end));
        for (var i = 0; i < repeat; i++) {
            builder.append(decodedInternal);
        }
        builder.append(decodeString(s.substring(end + 1)));

        return builder.toString();
    }

    /*
        Time complexity O(R)
        Space complexity O(R)

        R is resulting size

        but the solution has other numbers
     */
    public String decodeStringDeque(String s) {

        Deque<Character> deque = new ArrayDeque<>();
        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                var chars = new StringBuilder();
                while (deque.peek() != '[') { // form string
                    chars.append(deque.remove());
                }
                deque.remove(); // remove '['

                int base = 1;
                int repeat = 0;
                while (!deque.isEmpty() && deque.peek() >= '0' && deque.peek() <= '9') { //form repetitions
                    repeat += (deque.remove() - '0') *  base;
                    base *= 10;
                }

                for (; repeat > 0; repeat--) { // add characters
                    for (var cIndex = chars.length() - 1; cIndex >= 0; cIndex--) {
                        deque.push(chars.charAt(cIndex)); // add in reverse order
                    }
                }
            } else {
                deque.push(s.charAt(i));
            }

        }

        var sb = new StringBuilder(deque.size()); // can be replaced with char[]

        while (!deque.isEmpty()) {
            sb.append(deque.removeLast());
        }

        return sb.toString();
    }

    //TODO implementation with two stacks
}
