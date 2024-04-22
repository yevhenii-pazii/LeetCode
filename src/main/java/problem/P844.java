package problem;

import java.util.ArrayDeque;
import java.util.Deque;

class P844 {
    private static final char BACKSPACE = '#';

    public static void main(String[] args) {
        System.out.println(new P844().backspaceCompare("ab#c", "ad#c"));
        System.out.println(new P844().backspaceCompare("ab##", "c#d#"));
        System.out.println(new P844().backspaceCompare("a#c", "b"));
        System.out.println(new P844().backspaceCompare("aaa###a", "aaaa###a"));

        System.out.println();

        System.out.println(new P844().backspaceCompare2("ab#c", "ad#c"));
        System.out.println(new P844().backspaceCompare2("ab##", "c#d#"));
        System.out.println(new P844().backspaceCompare2("a#c", "b"));
        System.out.println(new P844().backspaceCompare2("aaa###a", "aaaa###a"));
    }

    public boolean backspaceCompare(String s, String t) {
        Deque<Character> sstack = parse(s);
        Deque<Character> tstack = parse(t);

        if (sstack.size() != tstack.size()) return false;

        while (!sstack.isEmpty()) {
            if (sstack.poll() != tstack.poll()) {
                return false;
            }
        }
        return true;
    }

    private static Deque<Character> parse(String string) {
        Deque<Character> stack = new ArrayDeque<>(string.length());
        for (var i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (c == BACKSPACE) {
                if (!stack.isEmpty()) {
                    stack.remove();
                }
            } else {
                stack.push(c);
            }
        }
        return stack;
    }

    public boolean backspaceCompare2(String s, String t) {
        int sback = 0, si = 1, tback = 0, ti = 1;
        while (s.length() - si >= 0 || t.length() - ti >= 0) {
            char schar = s.length() - si >= 0 ? s.charAt(s.length() - si) : 0;
            char tchar = t.length() - ti >= 0 ? t.charAt(t.length() - ti) : 0;

            if (schar == BACKSPACE) {
                sback++;
                si++;
                continue;
            }

            if (tchar == BACKSPACE) {
                tback++;
                ti++;
                continue;
            }

            if (sback > 0) {
                sback--;
                si++;
                continue;
            }

            if (tback > 0) {
                tback--;
                ti++;
                continue;
            }

            if (schar != tchar) {
                return false;
            } else {
                si++;
                ti++;
            }
        }

        return true;
    }
}
