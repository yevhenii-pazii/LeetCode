package problem;

import java.util.ArrayDeque;
import java.util.Deque;

public class P232 {

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    static class MyQueue {

        private final Deque<Integer> first = new ArrayDeque<>();
        private final Deque<Integer> second = new ArrayDeque<>();

        public MyQueue() {

        }

        public void push(int x) {
            first.push(x);
        }

        public int pop() {
            if (second.isEmpty()) {
                move();
            }
            return second.pop();
        }

        public int peek() {
            if (second.isEmpty()) {
                move();
            }
            return second.peek();
        }

        public boolean empty() {
            return first.isEmpty() && second.isEmpty();
        }

        private void move() {
            while (!first.isEmpty()) {
                second.push(first.pop());
            }
        }
    }

}
