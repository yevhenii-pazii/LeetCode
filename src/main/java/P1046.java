import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1046 {

    public static void main(String[] args) {
        System.out.println(new P1046().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(new P1046().lastStoneWeightArray(new int[]{2, 7, 4, 1, 8, 1}));
    }

    public int lastStoneWeight(int[] stones) {
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

    public int lastStoneWeightArray(int[] stones) {
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

}
