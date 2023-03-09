public class P1051 {

    public static void main(String[] args) {
        System.out.println(new P1051().heightChecker(new int[]{1, 1, 4, 2, 1, 3}));

    }

    // Using Counting Sort algorithm
    public int heightChecker(int[] heights) {
        var indexes = new int[101];
        var result = 0;
        //var sorted = new int[heights.length];

        for (var h : heights) {
            indexes[h]++;
        }

        for (var i = 1 ; i < indexes.length; i++) {
            indexes[i] += indexes[i - 1];
        }

        for (var i = 0 ; i < heights.length; i++) {
            /*
            var h = heights[i];
            var newIndex = --indexes[h];
            //sorted[newIndex] = h;
            if (heights[newIndex] != h) result++;
             */

            //sorted[newIndex] = h;
            if (heights[--indexes[heights[i]]] != heights[i]) result++; //Complicated because it is collapsed the full version is above
        }

        return result;
    }
}
