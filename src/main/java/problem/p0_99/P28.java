package problem.p0_99;

class P28 {
    public int strStrJava(String haystack, String needle) {
        return haystack.indexOf(needle);
    }


    /*
        Time O(n*m)
        Space O(1)
     */
    public int strStrOwn(String haystack, String needle) {
        MAIN: for (var i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (var j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    continue MAIN;
                }
            }
            return i;
        }
        return -1;
    }
}
