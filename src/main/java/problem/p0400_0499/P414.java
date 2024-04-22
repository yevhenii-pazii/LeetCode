package problem.p0400_0499;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

class P414 {

    public static void main(String[] args) {
        //System.out.println(new P414().thirdMax(new int[] {2, 2, 3, 1}));
        System.out.println(new P414().thirdMaxV2(new int[] {1,2,2,5,3,5}));

        //System.out.println(new P414().thirdMaxV2(new int[] {1,2}));
    }
    public int thirdMax(int[] nums) {
        List<Integer> maxList = new ArrayList<>(4);

        maxList.add(nums[0]);

        for (var n : nums) {
            for (var i = 0; i < maxList.size(); i++) {
                if (n > maxList.get(i)) {
                    maxList.add(i, n);
                    break;
                }
                if (n == maxList.get(i))
                    break;

                if (i == maxList.size() - 1 && maxList.size() < 3) {
                    maxList.add(n);
                }
            }
            if (maxList.size() == 4) maxList.remove(3);
        }


        return maxList.size() == 3 ? maxList.get(2) : maxList.get(0);
    }

    public int thirdMaxV2(int[] nums) {
        var max = new int[] {-1, -1, -1};
        int index, temp;
        for (var i = 0; i < nums.length; i++) {

            index = i;
            for (var j = 0; j < max.length; j++) {
                if (max[j] == -1) {
                    max[j] = index;
                    break;
                }

                if (nums[index] == nums[max[j]])
                    break;

                if (nums[index] > nums[max[j]]) {
                    temp = index;
                    index = max[j];
                    max[j] = temp;
                }
            }
        }

        return max[2] == -1 ? nums[max[0]] : nums[max[2]];
    }


    public int thirdMaxOfficial(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        Set<Integer> taken = new HashSet<Integer>();

        for (int index = 0; index < nums.length; ++index) {
            // If current number was already taken, skip it.
            if (taken.contains(nums[index])) {
                continue;
            }

            // If min heap already has three numbers in it.
            // Pop the smallest if current number is bigger than it.
            if (minHeap.size() == 3) {
                if (minHeap.peek() < nums[index]) {
                    taken.remove(minHeap.poll());

                    minHeap.add(nums[index]);
                    taken.add(nums[index]);
                }
            }
            // If min heap does not have three number we can push it.
            else {
                minHeap.add(nums[index]);
                taken.add(nums[index]);
            }
        }

        // 'nums' has only one distinct element it will be the maximum.
        if (minHeap.size() == 1) {
            return minHeap.peek();
        }
        // 'nums' has two distinct elements.
        else if (minHeap.size() == 2) {
            int firstNum = minHeap.poll();
            return Math.max(firstNum, minHeap.peek());
        }

        return minHeap.peek();
    }

}
