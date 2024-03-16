package problem.p0_99;

class P66 {
    /*
        Optimized for edge case
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int[] plusOneEdgeCase(int[] digits) {
        var all9 = true;

        var i = 0;
        while (all9 && i < digits.length) {
            all9 = digits[i] == 9;
            i++;
        }

        var result = digits;

        if (all9) {
            result = new int[digits.length + 1];
            result[0] = 1;
        } else {
            var extra = true;
            i = result.length - 1;
            while (extra) {
                if (result[i] == 9) {
                    result[i] = 0;
                } else {
                    extra = false;
                    result[i]++;
                }

                i--;
            }
        }

        return result;
    }

    /*
        Optimized for base case
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int[] plusOneBaseCaseOptimized(int[] digits) {
        for (var i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        var result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
