package problem;

class P1768 {

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public String mergeAlternately(String word1, String word2) {
        var builder = new StringBuilder(word1.length() + word2.length());

        var w1Index = 0;
        var w2Index = 0;
        while (w1Index < word1.length() && w2Index < word2.length()) {
            if (w2Index < w1Index) {
                builder.append(word2.charAt(w2Index++));
            } else {
                builder.append(word1.charAt(w1Index++));
            }
        }

        if (word1.length() - word2.length() > 0) {
            builder.append(word1, w1Index, word1.length());
        } else {
            builder.append(word2, w2Index, word2.length());
        }

        return builder.toString();
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public String mergeAlternatelyImproved(String word1, String word2) {
        var builder = new StringBuilder(word1.length() + word2.length());

        var commonPart = Math.min(word1.length(), word2.length());
        var i = 0;
        for (; i < commonPart; i++) {
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(i));
        }

        if (i < word1.length()) {
            builder.append(word1, i, word1.length());
        }

        if (i < word2.length()) {
            builder.append(word2, i, word2.length());
        }

        return builder.toString();
    }
}
