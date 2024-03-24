package problem.p0200_0299;

class P258 {

    /*
        Time Complexity O(N)
        Space Complexity O(1)
     */
    public int addDigitsLoop(int num) {
        while (num > 9) {
            var newNum = 0;
            do {
                newNum += num % 10;
                num /= 10;
            } while (num != 0);
            num = newNum;
        }
        return num;
    }

    /*
        Time Complexity O(N)
        Space Complexity O(N)
     */
    public int addDigitsRecursion(int num) {
        if (num < 10) return num;
        return addDigitsRecursion(num % 10 + addDigitsRecursion(num / 10));
    }

    /*
        There is a known formula to compute a digital root in a decimal numeral system
        https://leetcode.com/problems/add-digits/editorial/



        Time Complexity O(1)
        Space Complexity O(1)
    */
    public int addDigitsMath(int num) {
        return num == 0 ? 0 : 1 + (num - 1) % 9;
    }
}
