package problem.p0600_0699;

import java.util.ArrayDeque;
import java.util.Deque;

class P678 {

    public boolean checkValidString(String s) {
        return false;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)

        My solution beats 100%
     */
    public boolean checkValidStringTwoWays(String s) {
        int stars = 0, open = 0;

        for (int i = 0; i < s.length(); i++) { // first loop to handle overflow of '('
            var c = s.charAt(i);
            switch (c) {
                case '(' -> open++;
                case ')' -> open--;
                case '*' -> stars++;
            }

            if (open < 0 ) {
                if (stars == 0) {
                    return false;
                } else {
                    open++;
                    stars--;
                }
            }
        }

        if (open == 0) {
            return true;
        } else if (open > stars) {
            return false;
        } else {
            stars = 0;
            open = 0;
            for (int i = s.length() - 1; i >= 0; i--) { // second loop to handle overflow of ')'
                var c = s.charAt(i);

                switch (c) {
                    case ')' -> open++;
                    case '(' -> open--;
                    case '*' -> stars++;
                }

                if (open < 0 ) {
                    if (stars == 0) {
                        return false;
                    } else {
                        open++;
                        stars--;
                    }
                }
            }

            return open == 0 || stars >= open;
        }
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public boolean checkValidStringStack(String s) {
        Deque<Integer> opens = new ArrayDeque<>();
        Deque<Integer> stars = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);

            if (c == '(') {
                opens.push(i);
            } else if (c == ')') {
                if (opens.isEmpty()) {
                    if (stars.isEmpty()) {
                        return false;
                    } else {
                        stars.pop();
                    }
                } else {
                    opens.pop();
                }
            } else {
                stars.push(i);
            }
        }

        while (!opens.isEmpty() && !stars.isEmpty()) {
            var openIndex = opens.pop();
            var starIndex = stars.pop();
            if (starIndex < openIndex) {
                return false;
            }
        }

        return opens.isEmpty();
    }


    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public boolean checkValidStringTwo(String s) {
        int open = 0, close = 0, len = s.length();
        for (int i = 0; i < len; i++) {
            var cStart = s.charAt(i);
            if (cStart == '(' || cStart == '*') {
                open++;
            } else {
                open--;
            }


            var cEnd = s.charAt(len - 1 - i);
            if (cEnd == ')' || cEnd == '*') {
                close++;
            } else {
                close--;
            }

            if (open < 0 || close < 0) {
                return false;
            }

        }

        return true;
    }
}
