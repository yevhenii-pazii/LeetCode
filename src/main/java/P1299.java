import java.util.Arrays;

public class P1299 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new P1299().replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
    }

    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (var i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            arr[i] = max;
            max = Math.max(max, current);
        }
        return arr;
    }
}
