package problem.p0400_0499;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class P438 {

    public static void main(String[] args) {
        System.out.println(new P438().findAnagrams2("cbaebabacd", "abc"));
    }


    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return Collections.emptyList();

        char[] cs = s.toCharArray();
        int[] cpTable = new int['z' - 'a' + 1];
        int[] csTable = new int['z' - 'a' + 1];

        for (var i = 0; i < p.length(); i++) {
            cpTable[p.charAt(i) - 'a']++;
        }
        for (var i = 0; i < p.length() - 1 ; i++) {
            csTable[cs[i] - 'a']++;
        }

        List<Integer> result = new LinkedList<>();

        OUTER: for (var i = p.length() - 1; i < cs.length ; i++) {
            csTable[cs[i] - 'a']++;
            if (i - p.length() >= 0) {
                csTable[cs[i - p.length()] - 'a']--;
            }

            for (var j = 0; j < cpTable.length; j++) {
                if (cpTable[j] != csTable[j]) {
                    continue OUTER;
                }
            }
            result.add(i - p.length() + 1);
        }


        return result;
    }

    /*
        Not mine but interesting and working fine.
        Improved only the array size.
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> list = new LinkedList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int['z' - 'a' + 1];

        for (char c : p.toCharArray()) {
            hash[c - 'a']++;
        }

        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++) - 'a']-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++) - 'a']++ >= 0) count++;
        }
        return list;
    }
}
