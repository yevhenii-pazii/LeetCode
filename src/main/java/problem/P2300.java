package problem;

import java.util.Arrays;

class P2300 {

    /*
        Time Complexity O(N*M)
        Space complexity O(N)
     */
    public int[] successfulPairsBruteForce(int[] spells, int[] potions, long success) {
        var result = new int[spells.length];

        for (var i = 0; i < spells.length; i++) {
            for (var potion: potions) {
                if ((long) spells[i] * potion >= success) {
                    result[i]++;
                }
            }
        }

        return result;
    }

    /*
        Time Complexity O((N + M) * log M)
        Space complexity O(N + log M)
    */
    public int[] successfulPairsWithSortingAndBinarySearch(int[] spells, int[] potions, long success) {
        var result = new int[spells.length];
        Arrays.sort(potions); // could be improved with using optimal algorithm

        for (var i = 0; i < spells.length; i++) {
            long minPotionAllowed = success / spells[i] + (success % spells[i] == 0 ? 0 : 1);
            var minIndex = binarySearch(potions, minPotionAllowed);
            result[i] = potions.length - minIndex;
        }

        return result;
    }

    private int binarySearch(int[] array, long min) {
        var lo = 0;
        var hi = array.length - 1;

        var result = array.length; // this is special case

        while (lo <= hi) {
            var index = lo + (hi - lo) / 2;
            if (array[index] < min) {
                lo = index + 1;
            } else {
                result = Math.min(result, index);
                hi = index - 1;
            }
        }
        return result;
    }

    // there is one more option: Sorting + Two Pointers
    // sort both, use two pointers to traverse sorted arrays.
    // form result array
}
