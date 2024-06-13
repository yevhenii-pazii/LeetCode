package problem.p2000_2099;

import java.util.Arrays;

class P2037 {

    public int minMovesToSeat(int[] seats, int[] students) {
        return 0;
    }

    /*
        Time Complexity O(N) 100%
        Space Complexity O(K) 88.87% K - 100
        TODO single array can be used
     */
    public int minMovesToSeatCounting(int[] seats, int[] students) {
        int[] seatCount = new int[101];
        int[] studentCount = new int[101];

        for (var seat : seats) {
            seatCount[seat]++;
        }
        for (var student : students) {
            studentCount[student]++;
        }

        int moves = 0, seatIndex = 0, studentIndex = 0;
        for (int i = 0; i < seats.length; i++) {
            while (seatCount[seatIndex] == 0) {
                seatIndex++;
            }
            seatCount[seatIndex]--;

            while (studentIndex < studentCount.length && studentCount[studentIndex] == 0) {
                studentIndex++;
            }
            studentCount[studentIndex]--;

            moves += Math.abs(seatIndex - studentIndex);
        }


        return moves;
    }

    /*
        Time Complexity O(N * Log N) 97.38%
        Space Complexity O(1) 97.12%
     */
    public int minMovesToSeatSort(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int moves = 0;

        for (int i = 0; i < seats.length; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }

        return moves;
    }

}
