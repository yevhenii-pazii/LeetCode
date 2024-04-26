package problem;

class P374 {

    static class GuessGame {

        private final int pick;

        public GuessGame(int pick) {
            this.pick = pick;
        }

        int guess(int n) {
            return Integer.compare(pick, n);
        }
    }

    static class Solution extends GuessGame {

        public Solution(int pick) {
            super(pick);
        }

        public int guessNumber(int n) {
            int lo = 1, hi = n;

            var x = 1;
            while (lo <= hi) {
                x = lo + (hi - lo) / 2;

                if (guess(x) == 0) return x;
                if (guess(x) > 0) {
                    lo = x + 1;
                } else {
                    hi = x - 1;
                }

            }

            return x;
        }
    }
}
