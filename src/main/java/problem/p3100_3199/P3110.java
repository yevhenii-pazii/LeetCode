package problem.p3100_3199;

class P3110 {

    public int scoreOfString(String s) {
        return 0;
    }

    /*
        Time Complexity O(N) 99.87%
        Space Complexity O(1) 60%
     */
    public int scoreOfStringV1(String s) {
        int result = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            result += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }

        return result;
    }

}
