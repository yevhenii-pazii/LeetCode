package problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class P155 {

    /*
        Time Complexity O(1) for all operations
        Space complexity O(2N)

        Store value as 0 index and min at this point as 1 index
     */
    static class MinStack {
        private final Deque<int[]> stack = new ArrayDeque<>();

        public MinStack() {

        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(new int[]{val, val});
            } else {
                stack.push(new int[]{val, Math.min(val, stack.peek()[1])});
            }
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek()[0]; //OK by the problem rules
        }

        public int getMin() {
            return stack.peek()[1]; //OK by the problem rules
        }
    }

    /*
        Time Complexity O(1) for all operations
        Space complexity O(2N)

        Main stack
        Min Stack stores current min as 0 index and count of those as 1 index
     */
    static class MinStackV2 {
        private final Deque<Integer> stack = new ArrayDeque<>();
        private final Deque<int[]> minStack = new ArrayDeque<>();

        public MinStackV2() {

        }

        public void push(int val) {
            if (minStack.isEmpty()) {
                minStack.push(new int[]{val, 1});
            } else {
                if (getMin() == val) {
                    var count = minStack.peek();
                    count[1] += 1;
                } else if (getMin() > val) {
                    minStack.push(new int[]{val, 1});
                }
            }
            stack.push(val);
        }

        public void pop() {
            var current = stack.pop();

            if (getMin() == current) {
                var count = minStack.peek();
                if (count[1] == 1) {
                    minStack.pop();
                } else {
                    count[1] -= 1;
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek()[0];
        }
    }
}
