package problem.p0100_0199;

class P151 {

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public String reverseWordsTwoPointers(String s) {
        var builder = new StringBuilder(s.length() + 1);

        var end = s.length();
        int index;
        while (end >= 0) {
            index = end - 1;
            while (index >= 0 && s.charAt(index) != ' ') {
                index--;
            }

            var temp = index;

            if (end - index > 1) {
                for (index = index + 1; index < end; index++) {
                    builder.append(s.charAt(index));
                }
                builder.append(' ');
            }

            end = temp;
        }

        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }


    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public String reverseWordsArrayReverse(String s) {
        var chars = new char[s.length()];
        var charsLength = 0;

        var previousSpace = true;
        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (previousSpace) {
                    continue;
                } else {
                    previousSpace = true;
                }
            } else {
                previousSpace = false;
            }

            chars[charsLength++] = s.charAt(i);
        }

        if(chars[charsLength - 1] == ' ') {
            charsLength--;
        }
        reverse(chars, 0, charsLength - 1);

        var beginning = 0;
        for (var i = 0; i < charsLength; i++) {
            if (chars[i] == ' ') {
                reverse(chars, beginning, i - 1);
                beginning = i + 1;
            }
        }
        reverse(chars, beginning, charsLength - 1);

        return new String(chars, 0, charsLength);
    }

    private void reverse(char[] chars, int beginning, int end) {
        while (beginning < end) {
            var c = chars[beginning];
            chars[beginning] = chars[end];
            chars[end] = c;

            beginning++;
            end--;
        }
    }
}
