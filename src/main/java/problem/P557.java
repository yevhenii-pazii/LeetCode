package problem;

public class P557 {

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public String reverseWordsTwoPointers(String s) {
        var chars = new char[s.length()];
        var beginning = 0;
        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chars[i] = ' ';
                fillReversion(s, chars, beginning, i - 1);
                beginning = i + 1;
            }
        }
        fillReversion(s, chars, beginning, chars.length - 1);

        return new String(chars);
    }

    private void fillReversion(String s, char[] chars, int beginning, int end) {
        while (beginning <= end) {
            chars[beginning] = s.charAt(end);
            chars[end] = s.charAt(beginning);

            beginning++;
            end--;
        }
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public String reverseWordsTraverseAndReplace(String s) {
        var chars = new char[s.length()];
        var charsLength = 0;
        var beginning = 0;
        for (var i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                for (var j = i - 1; j >= beginning; j--) {
                    chars[charsLength++] = s.charAt(j);
                }
                chars[charsLength++] = ' ';
                beginning = i + 1;
            }
        }

        for (var j = s.length() - 1; j >= beginning; j--) {
            chars[charsLength++] = s.charAt(j);
        }

        return new String(chars);
    }
}
