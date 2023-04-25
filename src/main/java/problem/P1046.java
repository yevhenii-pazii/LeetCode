package problem;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1046 {


    public int lastStoneWeightPriorityQueue(int[] stones) {
        Queue<Integer> q = new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (var stone : stones) {
            q.add(stone);
        }

        while (q.size() > 1) {
            Integer stone1 = q.remove();
            Integer stone2 = q.remove();

            if (stone1 > stone2) {
                q.add(stone1 - stone2);
            }
        }

        return q.isEmpty() ? 0 : q.peek();
    }

    public int lastStoneWeightArraysSort(int[] stones) {
        int length = stones.length;
        Arrays.sort(stones);

        while (length > 1) {
            int stone1 = stones[length - 1];
            int stone2 = stones[length - 2];

            if (stone1 > stone2) {
                length--;
                stones[length - 1] = stone1 - stone2;
                Arrays.sort(stones);
            } else {
                length -= 2;
            }
        }

        return length == 0 ? 0 : stones[0];
    }

    public int lastStoneWeightArraysInsertingSort(int[] stones) {
        var length = stones.length;
        insertSort(stones, 1, length);

        while (length > 1) {
            var result = stones[length - 1] - stones[length - 2];
            if (result == 0) {
                length -= 2;
            } else {
                length--;
                stones[length - 1] = result;
                insertSort(stones, length - 1, length);
            }

        }

        return length == 0 ? 0 : stones[0];
    }

    private void insertSort(int[] numbers, int start, int length) {
        for (var i = start; i < length; i++) {
            var number = numbers[i];

            var j = i;
            while (j > 0 && numbers[j - 1] > number) {
                numbers[j] = numbers[--j];
            }
            numbers[j] = number;
        }
    }

    /*
        Simplified Insert Sort is used to insert result to a correct position

        Time Complexity O(N * log N)
        Space Complexity O(1)
     */
    public int lastStoneWeightArraysSortAndInsertingSort(int[] stones) {
        var length = stones.length;
        Arrays.sort(stones);

        while (length > 1) {
            var result = stones[length - 1] - stones[length - 2];
            if (result == 0) {
                length -= 2;
            } else {
                length--;

                // inserting sort
                var j = length - 1;
                while (j > 0 && stones[j - 1] > result) {
                    stones[j] = stones[--j];
                }
                stones[j] = result;
                //inserting sort
            }

        }

        return length == 0 ? 0 : stones[0];
    }

    /*
        Time Complexity O(N + W)
        Space Complexity O(W)

        W - is max stone Weight
     */
    public int lastStoneWeightArraysCountingSort(int[] stones) {
        var count = new int[1001]; // by the constraint of the problem

        for (var stone : stones) { //count all stones
            count[stone]++;
        }

        int biggestWeight = 0;
        int currentWeight = count.length - 1;
        while (currentWeight > 0) { // this could be improved
            if (count[currentWeight] == 0) {
                currentWeight--;
            } else if (biggestWeight == 0) {
                count[currentWeight] %= 2;
                if (count[currentWeight] == 1) {
                    biggestWeight = currentWeight;
                }
                currentWeight--;
            } else {
                count[currentWeight]--;
                if (biggestWeight - currentWeight <= currentWeight) {
                    count[biggestWeight - currentWeight]++;
                    biggestWeight = 0;
                } else {
                    biggestWeight -= currentWeight;
                }
            }
        }
        return biggestWeight;
    }

}
