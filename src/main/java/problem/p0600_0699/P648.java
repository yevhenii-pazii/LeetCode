package problem.p0600_0699;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class P648 {

    public String replaceWords(List<String> dictionary, String sentence) {
        return null;
    }

    /* N dictionary, M sentence
        Time Complexity O(N + M) 53.03%
        Space Complexity O(N) 12.5%

     */
    public String replaceWordsTrie(List<String> dictionary, String sentence) {

        class Trie {
            boolean word = false;
            Map<Character, Trie> children = new HashMap<>();
        }

        Trie root = new Trie();
        for (var word : dictionary) {
            var current = root;
            for (var i = 0; i < word.length(); i++) {
                var character = word.charAt(i);
                current = current.children.computeIfAbsent(character, c -> new Trie());
            }
            current.word = true;
        }

        StringBuilder result = new StringBuilder();

        StringBuilder word = new StringBuilder();
        boolean keepLooking = true;
        boolean addFullWord = true;
        Trie current = root;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);

            if (c == ' ') {
                result.append(word);
                word.setLength(0);
                keepLooking = true;
                addFullWord = true;
                current = root;
                word.append(c);
            } else if (keepLooking) {
                if (current.children.containsKey(c)) {
                    current = current.children.get(c);
                    if (current.word) {
                        keepLooking = false;
                        addFullWord = false;
                    }
                } else {
                    keepLooking = false;
                }
                word.append(c);
            } else if (addFullWord) {
                word.append(c);
            }

        }
        result.append(word);


        return result.toString();
    }

}
