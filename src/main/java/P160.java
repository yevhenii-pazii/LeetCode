public class P160 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this(x, null);
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + "v=" + val + ", n=" + next + '}';
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null) {
            var b = headB;

            while (b != null) {
                if (headA == b) {
                    return headA;
                }
                b = b.next;
            }

            headA = headA.next;
        }

        return null;
    }

    public ListNode getIntersectionNodeV2(ListNode headA, ListNode headB) {
        var aLength = 0;
        var bLength = 0;

        var a = headA;
        while (a != null) {
            aLength++;
            a = a.next;
        }

        var b = headB;
        while (b != null) {
            bLength++;
            b = b.next;
        }

        if (aLength > bLength) {
            for (int i = aLength - bLength; i > 0; i--) {
                headA = headA.next;
            }
        } else {
            for (int i = bLength - aLength; i > 0; i--) {
                headB = headB.next;
            }
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }

    public ListNode getIntersectionNodeV3(ListNode headA, ListNode headB) {
        var a = headA;
        var b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }
}
