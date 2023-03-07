public class P1346 {

    public static void main(String[] args) {
        System.out.println(new P1346().checkIfExist(new int[]{10, 2, 5, 3}));
        System.out.println(new P1346().checkIfExist(new int[]{3, 1, 7, 11}));
        System.out.println(new P1346().checkIfExist(new int[]{-2, 0, 10, -19, 4, 6, -8}));
    }

    public boolean checkIfExist(int[] arr) {
        for (var i = 0; i < arr.length - 1; i++) {
            for (var j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] * 2 || arr[j] == arr[i] * 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
