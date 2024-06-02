package problem.p0300_0399;

class P392 {

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;

        int i = 0, j = 0;
        int n = t.length();
        int m = s.length();

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();

        while (i < n) {
            if (tArray[i] == sArray[j]) {
                j++;
            }
            if (j == m) return true;
            i++;
        }
        return false;
    }

}
