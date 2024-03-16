package problem.p0_99;

class P50 {

    // Just a baseline not a real solution
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public double myPowRecursion(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            return 1 / myPowRecursionHelper(x, -n);
        } else {
            return myPowRecursionHelper(x, n);
        }
    }

    public double myPowRecursionHelper(double x, int n) {
        if (n == 1) return x;
        return x * myPowRecursionHelper(x, n - 1);
    }


    /*

        Time Complexity O(N)
        Space Complexity O(1)
     */
    public double myPowFlat(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (x * myPowFlatHelper(x, -(n + 1)));
            } else {
                return 1 / myPowFlatHelper(x, -n);
            }
        } else {
            return myPowFlatHelper(x, n);
        }
    }

    public double myPowFlatHelper(double x, int n) {
        var result = x;
        for (; n > 1; n--) {
            result *= x;
        }
        return result;
    }


    /*

        Time Complexity O(log N)
        Space Complexity O(1)
    */
    public double myPowMath(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (x * myPowMathHelper(x, -(n + 1)));
            } else {
                return 1 / myPowMathHelper(x, -n);
            }
        } else {
            return myPowMathHelper(x, n);
        }
    }

    public double myPowMathHelper(double x, int n) {
        var accumulator = 1.0;

        while (n > 1) {
            if (n % 2 == 1) accumulator *= x;
            n /= 2;
            x *= x;
        }
        return x * accumulator;
    }

}
