import structure.ListNode;

public class P2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        var result = new ListNode(-1);
        var current = result;

        boolean overflow = false;
        var sum = 0;

        while (l1 != null || l2 != null || overflow) {
            sum = (l1 == null ? 0 : l1.val) + (l2 == null? 0 : l2.val) + (overflow ? 1 : 0);

            if (sum >= 10) {
                overflow = true;
                sum -= 10;
            } else {
                overflow = false;
            }

            current.next = new ListNode(sum);
            current = current.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return result.next;
    }


    public ListNode addTwoNumbersRecursion(ListNode l1, ListNode l2) {
        return addTwoNumbersRecursion(l1, l2, false);
    }

    private ListNode addTwoNumbersRecursion(ListNode l1, ListNode l2, boolean overflow) {
        if (l1 == null && l2 == null && !overflow) return null;

        var sum = (l1 == null ? 0 : l1.val) + (l2 == null? 0 : l2.val) + (overflow ? 1 : 0);

        if (sum >= 10) {
            overflow = true;
            sum -=10;
        } else {
            overflow = false;
        }

        return new ListNode(sum, addTwoNumbersRecursion(l1 != null ? l1.next : null, l2 != null ? l2.next : null, overflow));
    }
}
