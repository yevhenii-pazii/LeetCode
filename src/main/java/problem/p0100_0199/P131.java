package problem.p0100_0199;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class P131 {

    public List<List<String>> partition(String s) {
        return null;
    }

    /*
        Time Complexity O() 5%
        Space Complexity O() 5%
     */
    public List<List<String>> partitionBacktracking(String s) {
        List<List<StringBuilder>> result = new LinkedList<>();

        List<StringBuilder> first = new LinkedList<>();
        first.add(new StringBuilder().append(s.charAt(0)));

        result.add(first);

        for (int i = 1; i < s.length(); i++) {
            List<List<StringBuilder>> additionalResults = new ArrayList<>(result.size() + 1);
            for (var list : result) {
                List<StringBuilder> newList = new ArrayList<>(list.size());
                for (var sb : list) {
                    newList.add(new StringBuilder(sb));
                }
                additionalResults.add(newList);
            }

            var currentChar = s.charAt(i);
            for (List<StringBuilder> l : additionalResults) {
                l.add(new StringBuilder().append(currentChar));
            }
            for (List<StringBuilder> l : result) {
                l.getLast().append(currentChar);
            }

            result.addAll(additionalResults);

            //remove not palindromes pre last items
            result.removeIf(list -> list.size() > 1 && !isPalindrome(list.get(list.size() - 2)));
        }

        //remove not palindromes last items
        result.removeIf(list -> !isPalindrome(list.getLast()));

        List<List<String>> answer = new ArrayList<>(result.size());
        for (List<StringBuilder> l : result) {
            List<String> newL = new ArrayList<>(l.size());

            for (var sb : l) {
                newL.add(sb.toString());
            }

            answer.add(newL);
        }

        return answer;
    }

    /*
        Time Complexity O() 5%
        Space Complexity O() 5%
     */
    public List<List<String>> partitionBacktrackingV2(String s) {
        int length = (int) Math.pow(2, s.length() - 1); //this is number of resulting lists

        char[][][] result = new char[length][s.length()][s.length()];
        int[][] wordLength = new int[length][s.length()];

        for (int ci = 0, flip = length; ci < s.length(); ci++, flip /= 2) { //loop over letters
            var c = s.charAt(ci);

            boolean addNew = true;
            int currentFlip = flip;

            MAIN:
            for (int i = 0; i < result.length; i++) { //loop over outer list
                for (int j = 0; j < result[i].length; j++) { //loop over list of words
                    if (wordLength[i][j] == 0) {
                        if (addNew) {
                            result[i][j][0] = c; // add to new word
                            wordLength[i][j]++;
                        } else {
                            result[i][j - 1][wordLength[i][j - 1]] = c; //add to previous word
                            wordLength[i][j - 1]++;
                        }
                        currentFlip--;

                        if (currentFlip == 0) {
                            currentFlip = flip;
                            addNew = !addNew;
                        }

                        continue MAIN; //letter added go to new list of words
                    }
                }

            }

        }

        List<List<String>> answer = new ArrayList<>(length);
        MAIN:
        for (int i = 0; i < result.length; i++) {

            List<String> words = new ArrayList<>(s.length());

            for (int j = 0; j < result[i].length; j++) {
                if (wordLength[i][j] == 0) {
                    break; //no mo words in the list
                }

                StringBuilder sb = new StringBuilder(wordLength[i][j]);
                sb.append(result[i][j], 0, wordLength[i][j]);

                if (isPalindrome(sb)) {
                    words.add(sb.toString()); // add word to the list
                } else {
                    continue MAIN; //word is not a palindrome so skipping the whole list;
                }
            }

            answer.add(words);
        }

        return answer;
    }



    /*
        Time Complexity O(N * 2 ^ N) 5.48%
        Space Complexity O(N) 82.35%
     */
    public List<List<String>> partitionBacktrackingV3(String s) {
        List<List<String>> result = new ArrayList<>();

        List<String> current = new ArrayList<>();
        current.add(s.charAt(0) + "");

        helperV1(s, 1, current, result);
        return result;
    }

    private static void helperV1(String s, int index, List<String> current, List<List<String>> result) {
        if (index == s.length()) {
            for (var word : current) {
                if (!isPalindrome(word)) {
                    return;
                }
            }

            result.add(current);
            return;
        }

        List<String> copy = new ArrayList<>(current);
        copy.add("" + s.charAt(index));

        current.set(current.size() - 1, current.getLast() + s.charAt(index));

        helperV1(s, index + 1, current, result);
        helperV1(s, index + 1, copy, result);

    }


    //TODO need to cover Editorial bouth options
    public List<List<String>> partitionV4(String s) {
        Map<String, Boolean> memo = new HashMap<>();


        return null;
    }

    private static void partitionV4helper(
        int start, String string, List<String> current, List<List<String>> result) {

        //for ()

    }

    private static boolean isPalindrome(CharSequence s) {
        if (s.length() == 1) {
            return true;
        }

        int p1 = 0, p2 = s.length() - 1;

        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                return false;
            }
            p1++;
            p2--;
        }
        return true;
    }


    private static boolean isPalindrome(CharSequence s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }
}
