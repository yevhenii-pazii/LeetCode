package problem.p0700_0799;

import java.util.ArrayDeque;
import java.util.Deque;

class P739 {

    /*
        Time Complexity O(N * N)
        Space Complexity O(1)
     */
    public int[] dailyTemperaturesBruteForce(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        MAIN:
        for (var i = 0; i < temperatures.length; i++) {
            for (var j = i + 1; j < temperatures.length; j++) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j - i;
                    continue MAIN;
                }
            }
        }

        return answer;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int[] dailyTemperaturesStack(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Deque<int[]> stack = new ArrayDeque<>();

        for (var i = 1; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                var item = stack.pop();
                answer[item[1]] = i - item[1];
            }

            if (temperatures[i - 1] < temperatures[i]) {
                answer[i - 1] = 1;
            } else {
                stack.push(new int[] {temperatures[i - 1], i - 1});
            }
        }

        return answer;
    }


    /*
        Time Complexity O(N)
        Space Complexity O(N)
    */
    public int[] dailyTemperaturesStackV2(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Deque<int[]> stack = new ArrayDeque<>();

        for (var i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                var item = stack.pop();
                answer[item[1]] = i - item[1];
            }

            stack.push(new int[] {temperatures[i], i});

        }

        return answer;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
    */
    public int[] dailyTemperaturesStackV3(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Deque<Integer> stack = new ArrayDeque<>();

        for (var i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                var previousIndex = stack.pop();
                answer[previousIndex] = i - previousIndex;
            }

            stack.push(i);
        }

        return answer;
    }

    //TODO additional solution with just hottest day and reusing answer
}
