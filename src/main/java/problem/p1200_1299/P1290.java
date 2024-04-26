package problem.p1200_1299;

import structure.ListNode;

class P1290 {

    public int getDecimalValue(ListNode head) {
        return 0;
    }

    /*
        Bit Manipulation

        Time Complexity O(N)
        Space complexity O(1)

     */
    public int getDecimalValueBit(ListNode head) {
        int result = 0;

        while (head != null) {
            result = result << 1;
            result |= head.val;

            head = head.next;
        }

        return result;
    }


    /*
        Binary Representation

        Time Complexity O(N)
        Space complexity O(1)

     */
    public int getDecimalValueBinary(ListNode head) {
        int result = 0;

        while(head != null) {
            result *= 2;
            result += head.val;

            head = head.next;
        }

        return result;
    }

}
