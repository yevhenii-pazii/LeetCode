package problem.p0900_0999;

import java.util.ArrayDeque;
import java.util.Deque;

class P946 {

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public boolean validateStackSequencesStack(int[] pushed, int[] popped) {
        Deque<Integer> stack = new ArrayDeque<>();

        var pushedIndex = 0;
        while (pushed[pushedIndex] != popped[0]) { // Find initial position
            stack.push(pushed[pushedIndex++]);
        }
        pushedIndex++;

        var poppedIndex = 1;
        while (poppedIndex < popped.length) {
            if (!stack.isEmpty() && popped[poppedIndex] == stack.peek()) {
                stack.pop();
                poppedIndex++;
                continue;
            }

            if (pushedIndex < pushed.length) {
                if (popped[poppedIndex] == pushed[pushedIndex]) {
                    poppedIndex++;
                } else {
                    stack.push(pushed[pushedIndex]);
                }
                pushedIndex++;
                continue;
            }

            return false;
        }

        return true;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public boolean validateStackSequencesArrayStack(int[] pushed, int[] popped) {
        var stack = new int[pushed.length];
        var stackIndex = 0;

        var pushedIndex = 0;
        while (pushed[pushedIndex] != popped[0]) { // Find initial position
            stack[stackIndex++] = pushed[pushedIndex++];
        }
        pushedIndex++;

        var poppedIndex = 1;
        while (poppedIndex < popped.length) {
            if (stackIndex > 0 && popped[poppedIndex] == stack[stackIndex - 1]) {
                stackIndex--;
                poppedIndex++;
                continue;
            }

            if (pushedIndex < pushed.length) {
                if (popped[poppedIndex] == pushed[pushedIndex]) {
                    poppedIndex++;
                } else {
                    stack[stackIndex++] = pushed[pushedIndex];
                }
                pushedIndex++;
                continue;
            }

            return false;
        }

        return true;
    }

    /*
        Official Solution

        Time Complexity O(N)
        Space Complexity O(N)
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int N = pushed.length;
        Deque<Integer> stack = new ArrayDeque<>();

        int j = 0;
        for (int x: pushed) {
            stack.push(x);
            while (!stack.isEmpty() && j < N && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        return j == N;
    }
}
