package problem;

public class P167 {

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int[] twoSumTwoPointers(int[] numbers, int target) {
        var p1 = 0;
        var p2 = numbers.length - 1;

        while (p1 < p2) {
            var sum = numbers[p1] + numbers[p2];

            if (sum == target) {
                return new int[]{++p1, ++p2};
            } else if (sum > target) {
                p2--;
            } else {
                p1++;
            }
        }

        return new int[]{0, 0};
    }

    /*
        Time Complexity O(N * log N)
        Space Complexity O(1)
     */
    public int[] twoSumBinarySearch(int[] numbers, int target) {
        for (var i = 0; i < numbers.length - 1; i++) {
            var index = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
            if (index != -1) {
                return new int[] {++i, ++index};
            }
        }

        return new int[]{0, 0};
    }

    private int binarySearch(int[] numbers, int lo, int hi, int target) {
        while (lo <= hi) {
            var middle = (lo + hi) / 2;

            if (numbers[middle] == target) {
                return middle;
            }

            if (numbers[middle] < target) {
                lo = middle + 1;
            } else {
                hi = middle - 1;
            }

        }

        return -1;
    }

    /*
        Time Complexity O(N * log N)
        Space Complexity O(1)
     */
    public int[] twoSumBinarySearch2(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;

        while (lo < hi) {
            var subTarget = target - numbers[lo];
            int subLo = lo + 1, subHi = hi;

            while (subLo < subHi) {
                var index = subLo + (subHi - subLo) / 2;
                if (numbers[index] == subTarget) {
                    return new int[] {lo + 1, index + 1};
                }

                if (numbers[index] < subTarget) {
                    subLo = index + 1;
                } else {
                    subHi = index;
                }
            }

            if (numbers[subLo] == subTarget) {
                return new int[] {lo + 1, subLo + 1};
            }

            lo++;
            hi = subLo;
        }

        return null;
    }
}
