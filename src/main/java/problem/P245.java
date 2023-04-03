package problem;

public class P245 {

    /*
        Time Complexity O(N) best case O(1)
        Space Complexity O(1)
     */
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        var min = wordsDict.length;

        var start = 0;
        for (; !wordsDict[start].equals(word1) && !wordsDict[start].equals(word2); start++) {

        } //need to find starting point
        var currentWord  = wordsDict[start];
        var lookingWord = word1.equals(currentWord) ? word2 : word1;

        for (var i = start + 1; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(lookingWord)) {
                min = Math.min(min, i - start);
                if (min == 1) { // min is 1 step this is min possible so stop looking for
                    return min;
                }

                start = i;
                var temp = currentWord;
                currentWord = lookingWord;
                lookingWord = temp;
            } else if (wordsDict[i].equals(currentWord)) {
                start = i;
            }
        }

        return min;
    }
}
