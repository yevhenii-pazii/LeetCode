package problem;

import java.util.ArrayDeque;
import java.util.Queue;

public class P225 {

    /*
        Time Complexity O(1) for all except pop which is O(N)
        Space Complexity O(N)
     */
    static class MyStack {

        private final Queue<Integer> queue = new ArrayDeque<>();
        private int top = 0;

        public MyStack() {

        }

        public void push(int x) {
            top = x;
            queue.add(x);
        }

        public int pop() {
            var moves = queue.size() - 2;
            for (var i = 0; i < moves; i++) {
                queue.add(queue.remove());
            }
            top = queue.remove();
            queue.add(top);
            return queue.remove();
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
