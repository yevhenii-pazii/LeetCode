package problem.p0400_0499;

import java.util.HashMap;
import java.util.Map;

class P409 {

    public static void main(String[] args) {
//        System.out.println((int) Character.valueOf('a'));
//        System.out.println((int) Character.valueOf('z'));
//
//        System.out.println((int) Character.valueOf('A'));
//        System.out.println((int) Character.valueOf('Z'));

        System.out.println(new P409().longestPalindromeV2("AAAAAAzz"));
    }

    public int longestPalindrome(String s) {
        var string = s.toCharArray();

        Map<Character, Integer> table = new HashMap<>();
        for (var c : string) {
            table.merge(c, 1, Integer::sum);
        }

        var length = 0;
        var oddAdded = false;
        for (var v : table.values()) {
            boolean isOdd = v % 2 == 1;
            length += v;
            if (isOdd) {
                if (oddAdded) {
                    length -= 1;
                } else {
                    oddAdded = true;
                }
            }
        }

        return length;
    }

    public int longestPalindromeV2(String s) {
        var string = s.toCharArray();

        var counts = new short['z' - 'A' + 1]; // letter range A-Z is 65-90 and a-z is 97-122 -> 122-65 = 57
        for (var c : string) {
            counts[c - 'A']++;
        }

        var length = 0;
        var oddAdded = false;
        for (var v : counts) {
            length += v;
            if (v % 2 == 1) {
                if (oddAdded) {
                    length -= 1;
                } else {
                    oddAdded = true;
                }
            }
        }

        return length;
    }
}
