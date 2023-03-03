public class P394 {

    public static void main(String[] args) {
        System.out.println(new P394().decodeString("3"));
        System.out.println(new P394().decodeString("b3[a]rg"));
        System.out.println(new P394().decodeString("3[a]2[bc]"));
        System.out.println(new P394().decodeString("3[a2[c]]"));
        System.out.println(new P394().decodeString("2[abc]3[cd]ef"));
    }

    public String decodeString(String s) {
        if (s.matches("\\d+")) return "";
        if (!s.contains("[")) return s;

        var builder = new StringBuilder();
        int start, end;
        for (start = 0; start < s.length(); start++) {
            var c = s.charAt(start);
            if ('a' <= c && c <= 'z') {
                builder.append(c);
            } else {
                break;
            }
        }

        for (end = start; end < s.length(); end++) {
            if (s.charAt(end) == '[') {
                break;
            }
        }

        int repeat = Integer.parseInt(s.substring(start, end));

        start = end + 1;
        int bracketCount = 0;
        for (end = start; end < s.length(); end++) {
            var c = s.charAt(end);
            if (c == '[') {
                bracketCount++;
                continue;
            }
            if (c == ']') {
                if (bracketCount == 0) {
                    break;
                } else {
                    bracketCount--;
                }
            }
        }


        var decodedInternal = decodeString(s.substring(start, end));
        for (var i = 0; i < repeat; i++) {
            builder.append(decodedInternal);
        }
        builder.append(decodeString(s.substring(end + 1)));

        return builder.toString();
    }
}
