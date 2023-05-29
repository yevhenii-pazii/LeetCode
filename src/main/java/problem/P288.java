package problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class P288 {

    static class ValidWordAbbr {

        private final Map<String, Set<String>> dict = new HashMap<>();

        public ValidWordAbbr(String[] dictionary) {
            for (var s : dictionary) {
                dict.computeIfAbsent(abbreviation(s), k -> new TreeSet<>()).add(s);
            }
        }

        public boolean isUnique(String word) {
            var abbr = abbreviation(word);

            Set<String> sameAbbr;

            return !dict.containsKey(abbr) ||
                    ((sameAbbr = dict.get(abbr)).size() == 1 && sameAbbr.contains(word));
        }

        private String abbreviation(String s) {
            if (s.length() < 3) return s;

            var builder = new StringBuilder(4);
            builder.append(s.charAt(0));
            builder.append(s.length() - 2);
            builder.append(s.charAt(s.length() - 1));

            return builder.toString();
        }
    }


    static class ValidWordAbbrV2 {

        private final Map<String, String> dict = new HashMap<>();

        public ValidWordAbbrV2(String[] dictionary) {
            for (var s : dictionary) {
               dict.compute(abbreviation(s), (k, v) -> v == null || v.equals(s) ? s : "");
            }
        }

        public boolean isUnique(String word) {
            var abbr = abbreviation(word);
            return !dict.containsKey(abbr) || dict.get(abbr).equals(word);

        }

        private String abbreviation(String s) {
            if (s.length() < 3) return s;

            var builder = new StringBuilder(4);
            builder.append(s.charAt(0));
            builder.append(s.length() - 2);
            builder.append(s.charAt(s.length() - 1));

            return builder.toString();
        }
    }
}
