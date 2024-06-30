package problem.p0600_0699;

import java.util.ArrayList;
import java.util.List;

class P633 {

    public boolean judgeSquareSum(int c) {
        return false;
    }

    public boolean judgeSquareSumBruteForce(int c) {
        for (long a = 0; a * a <= c; a++) {
            for (long b = 0; b * b <= c; b++) {
                if (a * a + b * b == c)
                    return true;
            }
        }
        return false;
    }

    /* Memory limit for 2147483646
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public boolean judgeSquareSumTwoPoints(int c) {
        List<Integer> squares = new ArrayList<>();
        int current = 0;
        int square = 0;
        squares.add(square);
        do {
            current++;
            square = current * current;
            squares.add(square);
        } while (square < c);

        int p1 = 0, p2 = squares.size() - 1;
        while (p1 <= p2) {
            int sum = squares.get(p1) + squares.get(p2);
            if (sum == c) {
                return true;
            } else if (sum < c) {
                p1++;
            } else {
                p2--;
            }
        }

        return false;
    }

    /* Time limit for 2147483646
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public boolean judgeSquareSumBinarySearch(int c) {
        int b = 0;
        while (b * b <= c) {
            b++;
        }
        b--;

        while (2 * b * b >= c) {
            int p1 = 0, p2 = b;
            while (p1 <= p2) {
                int mid = (p2 - p1) / 2 + p1;
                int sum = mid * mid + b * b;
                if (sum == c) {
                    return true;
                } else if (sum < c) {
                    p1 = mid + 1;
                } else {
                    p2 = mid - 1;
                }
            }
            b--;
        }

        return false;
    }

    public boolean judgeSquareSumFermatTheorem(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }

}
