package problem.p1200_1299;

import java.util.ArrayDeque;
import java.util.Deque;

class P1249 {

    public String minRemoveToMakeValid(String s) {
        return "";
    }

    /*
        Two pointers does not work for the cases: (l)ee(t)
        Or I just can not resolve it simply

     */
    public String minRemoveToMakeValidTwoPointers(String s) {
        int start = 0, end = s.length() - 1;
        var left = new StringBuilder(s.length());
        var right = new StringBuilder(s.length());

        while (start <= end) {

            //gp forward
            while (start <= end && s.charAt(start) != '(') {
                if (s.charAt(end) != ')') {
                    left.append(s.charAt(start));
                }
                start++;
            }

            //start == ( or it is end of string

            while (start <= end && s.charAt(end) != ')') {

            }


        }

        return left.append(right).toString();
    }

    /*
        Time Complexity O(N^2)
        Space Complexity O(N)
     */
    public String minRemoveToMakeValidPointers(String s) {
        var result = new StringBuilder(s.length());

        var length = s.length();
        var balanced = 0;
        var index = 0;
        var openBrackets = 0;

        while (balanced < length) {
            while (index < length && s.charAt(index) != '(') {
                if (s.charAt(index) != ')') {
                    result.append(s.charAt(index));
                }
                balanced++;
                index++;
            }

            //balanced == ( or it is end of string
            openBrackets++;
            index++;

            while (index < length && openBrackets != 0) {
                if (s.charAt(index) == ')') {
                    openBrackets--;
                } else if (s.charAt(index) == '(') {
                    openBrackets++;
                }
                index++;
            }

            if (openBrackets == 0) {
                result.append(s, balanced, index);
                balanced = index;
            } else {
                balanced++;
                index = balanced;
                openBrackets = 0;
            }
        }

        return result.toString();
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public String minRemoveToMakeValidStack(String s) {
        Deque<Integer> stack = new ArrayDeque<>();

        var length = s.length();
        var openBrackets = 0;

        var result = new StringBuilder(s.length());

        for (var i = 0; i < length; i++) {
            var c = s.charAt(i);

            if (c == '(') {
                openBrackets++;
                stack.push(result.length());
            }

            if (c == ')') {
                if (openBrackets == 0) {
                    continue;
                }
                openBrackets--;
                stack.pop();
            }
            result.append(c);
        }

        while (!stack.isEmpty()) {
            result.deleteCharAt(stack.pop());
        }

        return result.toString();
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
    */
    public String minRemoveToMakeValidTwoPass(String s) {
        var sb1 = new StringBuilder(s.length());
        var openTotal = 0;
        var openBrackets = 0;
        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            if (c == '(') {
                openBrackets++;
                openTotal++;
            }

            if (c == ')') {
                if (openBrackets == 0) {
                    continue;
                }
                openBrackets--;
            }

            sb1.append(c);
        }

        var sb2 = new StringBuilder(s.length());
        for (int i = 0, keep = openTotal - openBrackets; i < sb1.length(); i++) {
            var c = sb1.charAt(i);
            if (c == '(') {
                if (keep == 0) {
                    continue;
                }
                keep--;
            }
            sb2.append(c);
        }

        return sb2.toString();
    }
}
