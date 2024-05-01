package problem.p2000_2099;

class P2000 {

    public String reversePrefix(String word, char ch) {
        return null;
    }


    /*
        Time Complexity O(N) 100%
        Space Complexity O(N) 70%
     */
    public String reversePrefixTwoPoint(String word, char ch) {
        var i = 0;
        while (i < word.length() && word.charAt(i) != ch) {
            i++;
        }

        if (i == 0 || i == word.length()) {
            return word;
        } else {
            var j = 0;

            StringBuilder builder = new StringBuilder(word);

            while (j < i) {
                var temp = builder.charAt(i);
                builder.setCharAt(i, builder.charAt(j));
                builder.setCharAt(j, temp);
                j++;
                i--;
            }

            return builder.toString();
        }
    }

}
