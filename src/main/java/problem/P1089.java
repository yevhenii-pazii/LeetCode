package problem;

class P1089 {

    public void duplicateZeros(int[] arr) {
        for (var i = 0; i < arr.length - 1; i++) {
            if (arr[i] == 0) {
                for (var j = arr.length-1; j > i; j--) {
                    arr[j] = arr[j-1];
                }
                i++;
            }
        }
    }
}
