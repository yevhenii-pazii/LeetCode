package problem.p0400_0499;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class P402 {
    public String removeKdigits(String num, int k) {
        return "";
    }

    /*
        TIME LIMIT EXCEED

        Time Complexity: O(N!)
        Space Complexity: O(N)
     */
    public String removeKdigitsM(String num, int k) {
        var original = new StringBuilder(num);

        PriorityQueue<StringBuilder> heap = new PriorityQueue<>(k,
                (sb1, sb2) -> {
                    if (sb1.length() != sb2.length()) return sb1.length() - sb2.length();

                    for (var i = 0; i < sb1.length(); i++) {
                        if (sb1.charAt(i) != sb2.charAt(i)) {
                            return sb1.charAt(i) - sb2.charAt(i);
                        }
                    }

                    return 0;
                }); // can be removed to store only one and compare when new generated

        for (; k > 0; k--) {
            for (var i = 0; i < original.length(); i++) {
                var newnum = new StringBuilder(original).deleteCharAt(i);
                heap.offer(newnum);
            }

            original = heap.poll();
            heap.clear();
        }

         while (!original.isEmpty() && original.charAt(0) == '0') {
             original.deleteCharAt(0);
         }

        return original.isEmpty() ? "0" : original.toString();
    }

    /*

     */
    public String removeKdigitsLinear(String num, int k) {
        if (num.length() == k) return "0";
        var original = new StringBuilder(num);

        for (; k > 0; k--) {
            for (var i = 0; i < original.length(); i++) {
                if (i + 1 == original.length() || original.charAt(i) > original.charAt(i + 1)) {
                    original.deleteCharAt(i);
                    break;
                }
            }

            while (!original.isEmpty() && original.charAt(0) == '0') {
                original.deleteCharAt(0);
            }
        }

        return original.isEmpty() ? "0" : original.toString();
    }

    /*
        Time complexity O(N)
        Space Complexity O(1)

        Passed
     */
    public String removeKdigitsInPlace(String num, int k) {
        var original = new StringBuilder(num);

        var i = 0;
        while (k > 0) {
            if (i + 1 == original.length() || original.charAt(i) > original.charAt(i + 1)) {
                original.deleteCharAt(i);
                k--;
                if (i > 0) {
                    i--;
                }
            } else {
                i++;
            }
        }

        while (!original.isEmpty() && original.charAt(0) == '0') {
            original.deleteCharAt(0);
        }

        return original.isEmpty() ? "0" : original.toString();
    }

    public String removeKdigitsInPlaceWithStack(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();

        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > c) {
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }

        for (; k > 0; k--) {
            stack.removeLast();
        }

        while (!stack.isEmpty() && stack.getFirst() == '0') {
            stack.removeFirst();
        }

        var result  = new StringBuilder(stack.size());
        for (char c : stack) {
            result.append(c);
        }

        return result.isEmpty() ? "0" : result.toString();
    }

    public String removeKdigitsOfficial(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        /* remove the remaining digits from the tail. */
        for(int i=0; i<k; ++i) {
            stack.removeLast();
        }

        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }

        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }
}
