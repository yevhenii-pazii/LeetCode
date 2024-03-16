package problem;

import java.util.ArrayDeque;
import java.util.Deque;

class P9 {

    /*
        Time Complexity: O(N)
        Space Complexity: O(N)
     */
    public boolean isPalindromeString(int x) {
        var numberString = String.valueOf(x);

        for (var i = 0; i < numberString.length() / 2; i++) {
            if (numberString.charAt(i) != numberString.charAt(numberString.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    /*
        Time Complexity: O(2 log(n))
        Space Complexity: O(N)
    */
    public boolean isPalindromeDivide(int x) {
        if (x < 0) {
            return false;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        while (x > 0) {
            deque.push(x % 10);
            x /= 10;
        }

        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }

        return true;
    }

    /*
        Time Complexity: O(log (n))
        Space Complexity: O(1)
    */
    public boolean isPalindromeMiddleElement(int x) {
        if (x == 0) {
            return true;
        }

        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return x == reversed || x == reversed / 10;
    }



}
