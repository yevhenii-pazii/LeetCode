package problem.p0900_0999;

class P941 {

    public static void main(String[] args) {
        System.out.println(new P941().validMountainArray(new int[]{2, 1}));
        System.out.println(new P941().validMountainArray(new int[]{3, 5, 5}));
        System.out.println(new P941().validMountainArray(new int[]{0, 3, 2, 1}));
    }

    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3 || arr[0] >= arr[1]) return false;
        boolean growing = true;

        for (var i = 1; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) return false;

            if (growing) {
                growing = arr[i] < arr[i + 1];
            } else {
                if (arr[i] < arr[i + 1]) {
                    return false;
                }
            }
        }
        return !growing;
    }
}
