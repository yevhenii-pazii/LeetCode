package problem.p1000_1099;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class P1046 {


    /*
        Time Complexity O(N * Log (N) + N * Log (N))
        Space Complexity O(N)
     */
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

    /*
        Time Complexity O(N + N * log N)
        Space Complexity O(1)
     */
    public int lastStoneWeightHeap(int[] stones) {
        int length = stones.length;

        heapify(stones, length);

        while (length > 1) {
            var one = pop(stones, length--);
            var two = pop(stones, length--);
            if (one > two) {
                add(one - two, stones, length++);
            }
        }

        return length == 0 ? 0 : stones[0];
    }

    /*
        Max Heap
        Time Complexity O(N)
     */
    private static void heapify(int[] array, int length) {
        for (var index = length / 2; index > 0; index--) {
            var i = index;
            while (i <= length / 2) { //while not a leaf
                var node = array[i - 1];
                var leftIndex = i * 2;

                if (array[leftIndex - 1] > node) {
                    var rightIndex = i * 2 + 1;
                    if (rightIndex <= length && array[rightIndex - 1] > array[leftIndex - 1]) { // take right
                        array[i - 1] = array[rightIndex - 1];
                        array[rightIndex - 1] = node;
                        i = i * 2 + 1;
                    } else { //take left
                        array[i - 1] = array[leftIndex - 1];
                        array[leftIndex - 1] = node;
                        i = i * 2;
                    }
                } else {
                    var rightIndex = i * 2 + 1;
                    if (rightIndex <= length && array[rightIndex - 1] > node) {
                        array[i - 1] = array[rightIndex - 1];
                        array[rightIndex - 1] = node;
                        i = i * 2 + 1;
                    } else {
                        break; // no swap needed
                    }
                }
            }
        }
    }

    /*
        Max Heap
        Time Complexity O(log N)
     */
    private static int pop(int[] array, int length) {
        var head = array[0];

        array[0] = array[--length];
        var i = 1;
        while (i <= length/2) { //while not leaf
            var node = array[i - 1];
            var leftIndex = i * 2;

            if (array[leftIndex - 1] > node) {
                var rightIndex = i * 2 + 1;

                if (rightIndex <= length && array[rightIndex - 1] > array[leftIndex - 1]) { //take right
                    array[i - 1] = array[rightIndex - 1];
                    array[rightIndex - 1] = node;

                    i = i * 2 + 1;
                } else { //take left
                    array[i - 1] = array[leftIndex - 1];
                    array[leftIndex - 1] = node;

                    i = i * 2;
                }

            } else {
                var rightIndex = i * 2 + 1;

                if (rightIndex <= length && array[rightIndex - 1] > node) { //take right
                    array[i - 1] = array[rightIndex - 1];
                    array[rightIndex - 1] = node;

                    i = i * 2 + 1;
                } else {
                    break; //no swaps needed
                }
            }
        }

        return head;
    }

    /*
        Max Heap
        Time Complexity O(log N)
    */
    private static void add(int value, int[] array, int length) {
        array[length++] = value;
        var i = length;
        while (i > 1) {
            var parentIndex = i / 2;
            if (array[parentIndex - 1] < value) {
                array[i - 1] = array[parentIndex - 1];
                array[parentIndex - 1] = value;
                i = parentIndex;
            } else {
                i = 1; // to exit, no need to swap
            }
        }
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
        Time Complexity O(N^2 + N)
        Space Complexity O(1)
     */
    public int lastStoneWeightArraysInsertingSortV2(int[] stones) {
        var length = stones.length;

        for(var i = 1; i < length; i++) { //insertion sort
            var number = stones[i];

            var j = i;
            while (j > 0 && stones[j - 1] > number) {
                stones[j] = stones[--j];
            }
            stones[j] = number;
        }

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
                // inserting sort
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
