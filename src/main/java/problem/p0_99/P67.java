package problem.p0_99;

import java.math.BigInteger;

class P67 {


    /*
        This is perfect solution, but 1 <= a.length, b.length <= 104 which is wider than even Long.
     */
    public String addBinaryMath(String a, String b) {
        return Long.toString(Long.parseLong(a, 2) + Long.parseLong(b, 2), 2);
    }

    public String addBinaryMathBigInt(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }

    /*
        Time Complexity O(max(M, N))
        Space Complexity O(max(M, N)) to keep string builder
     */
    public String addBinary(String a, String b) {
        var aIndex = a.length();
        var bIndex = b.length();

        var capacity = Math.max(aIndex, bIndex);
        var builder = new StringBuilder(capacity + 1);

        int extra = 0x0;
        int aBit;
        int bBit;
        int sum;
        for (var i = 0; i < capacity; i++) {
            if (aIndex > 0 && a.charAt(--aIndex) == '1') {
                aBit = 0x1;
            } else {
                aBit = 0x0;
            }

            if (bIndex > 0 && b.charAt(--bIndex) == '1') {
                bBit = 0x1;
            } else {
                bBit = 0x0;
            }

            sum = aBit + bBit + extra;
            builder.append(sum & 0x1);
            extra = sum >>> 1 & 0x1;
        }

        if (extra == 1) {
            builder.append(1);
        }

        builder.reverse();
        return builder.toString();
    }
}
