package problem.p1600_1699;

import java.util.PriorityQueue;

class P1642 {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        return 0;
    }

    /* My
        Time Complexity O(N * ln N) 66.78%
        Space Complexity O(N) 92.28%
     */
    public int furthestBuildingHeap(int[] heights, int bricks, int ladders) {
        int buildingIndex = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        while (bricks >= 0 && buildingIndex < heights.length - 1) {
            int climb = heights[buildingIndex + 1] - heights[buildingIndex];
            if (climb > 0) { //next building is smaller
                heap.add(climb);
                if (ladders > 0) {
                    ladders--;
                } else {
                    bricks -= heap.poll();
                }
            }
            buildingIndex++;
        }

        return bricks >= 0 ? buildingIndex : buildingIndex - 1;
    }

    //TODO other implementations for binary search
}
