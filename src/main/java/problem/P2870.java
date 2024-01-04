package problem;

import java.util.HashMap;
import java.util.Map;

class P2870 {

    /*
        Time Complexity O(N + N * N) ?? note sure
        Space Complexity O(N)
     */
    public int minOperationsRecursion(int[] nums) {
        var operations = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (var num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (var num : countMap.keySet()) {
            var countForNumber = countForNumberRecursion(countMap.get(num));
            if (countForNumber == -1) {
                return -1;
            } else {
                operations += countForNumber;
            }
        }


        return operations;
    }

    private int countForNumberRecursion(int number) {
        if (number == 1) {
            return -1;
        }
        if (number == 2 || number == 3) {
            return 1;
        }
        if (number == 4) {
            return 2;
        }

        return 1 + countForNumberRecursion(number - 3);
    }

    /*
        Time Complexity O(N + N * N) ?? note sure
        Space Complexity O(N)
    */
    public int minOperationsMemo(int[] nums) {
        var operations = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (var num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(2, 1);
        memo.put(3, 1);
        memo.put(4, 2);

        for (var num : countMap.keySet()) {
            var repetitions = countMap.get(num);
            if (repetitions == 1) {
                return -1;
            }

            if (memo.containsKey(repetitions)) {
                operations += memo.get(repetitions);
                continue;
            }

            var count = 0;
            var currentRepetitions = repetitions;
            while (!memo.containsKey(currentRepetitions)) {
                currentRepetitions -= 3;
                count++;
                memo.putIfAbsent(repetitions - currentRepetitions, count);
            }
            count += memo.get(currentRepetitions);
            memo.put(repetitions, count);

            operations += count;
        }

        return operations;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
    */
    public int minOperationsMemoV2(int[] nums) {
        var operations = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (var num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(2, 1);
        memo.put(3, 1);
        memo.put(4, 2);

        for (var num : countMap.keySet()) {
            var repetitions = countMap.get(num);
            if (repetitions == 1) {
                return -1;
            }

            if (memo.containsKey(repetitions)) {
                operations += memo.get(repetitions);
            } else {
                var count = repetitions / 3;
                var left = repetitions % 3;
                if (left != 0) {
                    count++;
                }
                memo.put(repetitions, count);
                operations += count;
            }
        }

        return operations;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
    */
    public int minOperationsMath(int[] nums) {
        var operations = 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (var num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        for (var num : countMap.keySet()) {
            var repetitions = countMap.get(num);
            if (repetitions == 1) {
                return -1;
            }
            var count = repetitions / 3;
            var left = repetitions % 3;
            if (left != 0) {
                count++;
            }
            operations += count;
        }

        return operations;
    }
}
