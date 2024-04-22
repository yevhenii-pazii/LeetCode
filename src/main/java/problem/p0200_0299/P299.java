package problem.p0200_0299;

class P299 {

    public static void main(String[] args) {
        System.out.println(new P299().getHint2("1807", "7810"));
        System.out.println(new P299().getHint2("1123", "0111"));
    }

    public String getHint(String secret, String guess) {
        int[] s = new int[secret.length()], g = new int[secret.length()], sCounts = new int[10];

        for (var i = 0; i < secret.length(); i++) {
            int secretNumber = Character.getNumericValue(secret.charAt(i));
            s[i] = secretNumber;
            sCounts[secretNumber]++;
            g[i] = Character.getNumericValue(guess.charAt(i));
        }

        int bulls = 0, cows = 0;
        for (var i = 0; i < g.length; i++) {
            if (s[i] == g[i]) {
                bulls++;
                cows--;
            }
            if (--sCounts[g[i]] >= 0) {
                cows++;
            }
        }

        return String.valueOf(bulls) + 'A' + cows + 'B';
    }

    /*
        TO do not mine, but interesting
     */
    public String getHint2(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int s = Character.getNumericValue(secret.charAt(i));
            int g = Character.getNumericValue(guess.charAt(i));
            if (s == g)
                bulls++;
            else {
                if (numbers[s] < 0) cows++;
                if (numbers[g] > 0) cows++;
                numbers[s]++;
                numbers[g]--;
            }
        }
        return bulls + "A" + cows + "B";
    }

}
