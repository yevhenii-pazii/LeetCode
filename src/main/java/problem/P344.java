package problem;

public class P344 {

    /*
        Time O(N)
        Space O(1)
     */
    public void reverseString(char[] s) {
        if (s == null) return;
        char temp;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    /*
        Time O(N)
        Space O(N)
     */
    public void reverseStringRecursion(char[] s) {
        if (s == null) return;

        doReverseStringRecursion(s, 0, s.length - 1);
    }

    private void doReverseStringRecursion(char[] s, int forward, int revers) {
        if (forward >= revers) return;

        var temp = s[forward];
        s[forward] = s[revers];
        s[revers] = temp;
        doReverseStringRecursion(s, ++forward, --revers);
    }
}