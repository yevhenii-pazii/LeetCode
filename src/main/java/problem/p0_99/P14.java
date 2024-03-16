package problem.p0_99;

class P14 {

    /*
        TODO there are a lot of interesting solutions
            Horizontal scanning
            Vertical scanning
            Divide and conquer
            Binary search

     */

    /*
        Time O(N)
        Space O(1)
     */
    public String longestCommonPrefix(String[] strs) {
        var min = strs[0].length();
        for (var str: strs) {
            min = Math.min(min, str.length());
        }

        var builder = new StringBuilder(min);
        for (var cIndex = 0; cIndex < min; cIndex++) {
            var c = strs[0].charAt(cIndex);

            for (var strIndex = 1; strIndex < strs.length; strIndex++) {
                if (strs[strIndex].charAt(cIndex) != c) {
                    return builder.toString();
                }
            }
            builder.append(c);
        }

        return builder.toString();
    }

}
