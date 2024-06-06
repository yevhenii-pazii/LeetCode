package problem.p0800_0899;

import java.util.Arrays;

class P846 {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        return false;
    }

    /* Iterative
        Time Complexity O(N Log N) 63.63%
        Space Complexity O(N) 89.81%
     */
    public boolean isNStraightHandV1(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);

        int[][] groups = new int[hand.length / groupSize][groupSize + 1]; //0 index - is length

        int group = 0;
        MAIN:
        for (int num : hand) {
            int groupIndex = groups[group][0];
            if (groupIndex == 0 || num - groups[group][groupIndex] == 1) { // insert element in current group
                groups[group][++groupIndex] = num;
                groups[group][0] = groupIndex; // set new size
                if (groupIndex == groupSize) { //group is full
                    group++;
                }
            } else { // need to insert into following group
                int nextGroup = group + 1;

                while (nextGroup < groups.length && groups[nextGroup][0] < groupSize) {
                    int nextGroupIndex = groups[nextGroup][0];
                    if (nextGroupIndex == 0 || (num - groups[nextGroup][nextGroupIndex] == 1)) {
                        groups[nextGroup][++nextGroupIndex] = num;
                        groups[nextGroup][0] = nextGroupIndex; // set new size
                        continue MAIN;
                    } else {
                        nextGroup++;
                    }
                }

                return false; // no place to insert

            }
        }

        return true;
    }

    /*
        9%
        52%
     */
    public boolean isNStraightHandV2(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        Arrays.sort(hand);

        int[][] groups = new int[hand.length / groupSize][groupSize + 1]; //0 index - is length

        int nextGroup = 0;
        MAIN:
        for (int num : hand) {

            while (nextGroup < groups.length ) {
                int nextGroupIndex = groups[nextGroup][0];
                if (nextGroupIndex == 0 || groups[nextGroup][0] < groupSize && (num - groups[nextGroup][nextGroupIndex] == 1)) {
                    groups[nextGroup][++nextGroupIndex] = num;
                    groups[nextGroup][0] = nextGroupIndex; // set new size
                    continue MAIN;
                } else {
                    nextGroup++;
                }
            }

            return false; // no place to insert

        }

        return true;
    }

    //TODO Map with counting; Rerverse Decrement
}
