package problem;

import java.util.Arrays;

public class P2405 {

    /*
        My solution
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int partitionString(String s) {
        var input = s.toCharArray();
        var hashTable = new boolean['z' - 'a' + 1];

        var count = 1;
        for (var c : input) {
            var key = c - 'a';
            if (hashTable[key]) {
                count++;
                //Arrays.fill is good for readability but not for performance
                for (var j = 0; j < hashTable.length; j++) {
                    hashTable[j] = false;
                }
            }
            hashTable[key] = true;
        }

        return count;
    }

    /*
        Not mine but even better performance
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int partitionStringLastSeen(String s) {
        var lastSeen = new int['z' - 'a' + 1];
        //Arrays.fill is good for readability but not for performance
        for (var i = 0; i < lastSeen.length; i++) {
            lastSeen[i] = -1;
        }
        int count = 1;
        int startOfSubString = 0;

        for (var i = 0 ; i < s.length(); i++) {
            var key = s.charAt(i) - 'a';
            if (lastSeen[key] >= startOfSubString) {
                count++;
                startOfSubString = i;
            }
            lastSeen[key] = i;
        }

        return count;
    }
}
