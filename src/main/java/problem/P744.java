package problem;

public class P744 {

    /*
        Time Complexity O(log N)
        Space Complexity O(1)
     */
    public char nextGreatestLetterBinarySearchTemplate1(char[] letters, char target) {
        int lo = 0, hi = letters.length - 1;
        char result = letters[0];

        while (lo <= hi) {
            var index = lo + (hi - lo) / 2;

            if (letters[index] > target) {
                hi = index - 1;
                result = letters[index];
            } else {
                lo = index + 1;
            }
        }

        return result;
    }

    /*
        Time Complexity O(log N)
        Space Complexity O(1)
     */
    public char nextGreatestLetterBinarySearchTemplate3(char[] letters, char target) {
        int lo = 0, hi = letters.length - 1;

        while (lo < hi - 1) {
            var index = lo + (hi - lo) / 2;

            if (letters[index] > target) {
                hi = index;
            } else {
                lo = index;
            }
        }

        return letters[lo] > target ? letters[lo] : letters[hi] > target ? letters[hi] : letters[0];
    }
}
