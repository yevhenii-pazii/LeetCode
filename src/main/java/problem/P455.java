package problem;

import java.util.Arrays;

public class P455 {

    /*
        Time Complexity O(N + M) + two sorting, O(n log(n)) -> O(N log(M) + M log(M))
        Space Complexity O(1)
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while(i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }

        return i;
    }
}
