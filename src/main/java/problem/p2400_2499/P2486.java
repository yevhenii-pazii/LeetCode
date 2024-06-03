package problem.p2400_2499;

class P2486 {

    public int appendCharacters(String s, String t) {
        return 0;
    }


    /*
        Time Complexity O(N) 66.26%
        Space Complexity O(1) 50.79%
     */
    public int appendCharactersTwoPoints(String s, String t) {
        int si = 0;
        int ti = 0;

        while (si < s.length() && ti < t.length()) {
            if (s.charAt(si) == t.charAt(ti)) {
                ti++;
            }
            si++;
        }

        return t.length() - ti;
    }
}
