package problem.p1400_1499;

class P1404 {

    public int numSteps(String s) {
        return 0;
    }

    /*
        Cant handle long strings
     */
    public int numStepsBitManipulation(String s) {
        int result = 0;

        long number = Long.parseLong(s, 2);
        while (number != 1) {
            if ((number & 1) == 1) {
                number += 1;
            } else {
                number /= 2;
            }

            result++;
        }

        return result;
    }

    /*
        Time Complexity O(N) 38.84%
        Space Complexity O(N) 57.64%
     */
    public int numStepsArray(String s) {
        int result = 0;
        boolean[] number = new boolean[s.length()];
        for (var i = 0; i < s.length(); i++) {
            number[i] = s.charAt(i) == '1';
        }

        for (var i = number.length - 1; i > 0; i--) {
            if (number[i]) {
                int j = i;
                while (j >= 0 && number[j]) {
                    number[j] = false;
                    j--;
                }
                if (j != -1) {
                    number[j] = true;
                }
                result += 2; // +1 and /2 as one step
            } else {
                result++; // /2
            }
        }


        return number[0] ? result : result + 1;
    }

    /* Not mine
        Time Complexity O(N) 38.84%
        Space Complexity O(N) 23.55%
     */
    public int numStepsBit(String s) {
        int n = s.length();

        int operations = 0;
        int carry = 0;
        for (int i = n - 1; i > 0; i--) {
            int digit = Character.getNumericValue(s.charAt(i)) + carry;

            if (digit % 2 == 1) {
                operations += 2;
                carry = 1;
            } else {
                operations++;
            }
        }

        return operations + carry;
    }
}
