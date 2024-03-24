package problem.p0200_0299;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class P253 {

    public int minMeetingRooms(int[][] intervals) {
        return 0;
    }

    /*
        Time Complexity O(N * Log N)
        Space Complexity O(N)

        TODO custom heap
     */
    public int minMeetingRoomsPriorityQueue(int[][] intervals) {
        Queue<int[]> sortedIntervals = new PriorityQueue<>(
                intervals.length,
                Comparator.<int[]>comparingInt(i -> i[0]).thenComparingInt(i -> i[1]));
        sortedIntervals.addAll(Arrays.asList(intervals));

        var minRooms = 0;
        var rooms = 0;


        Queue<Integer> allocator = new PriorityQueue<>();

        while (!sortedIntervals.isEmpty()) {
            var interval = sortedIntervals.poll();

            while (!allocator.isEmpty() && allocator.peek() <= interval[0]) {
                allocator.remove();
                rooms--;
            }

            allocator.add(interval[1]);
            rooms++;

            minRooms = Math.max(rooms, minRooms);
        }


        return minRooms;
    }
}
