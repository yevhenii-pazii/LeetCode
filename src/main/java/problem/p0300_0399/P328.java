package problem.p0300_0399;

class P328 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + "val=" + val + ", next=" + next + '}';
        }
    }

    public ListNode oddEvenList(ListNode head) {
        var oddHead = new ListNode(0);  // sentinel
        var evenHead = new ListNode(0); // sentinel
        var oddCurrent = oddHead;
        var evenCurrent = evenHead;
        boolean odd = true;
        while (head != null) {
            if (odd) {
                oddCurrent.next = head;
                oddCurrent = head;
            } else {
                evenCurrent.next = head;
                evenCurrent = head;
            }
            head = head.next;
            odd = !odd; //flipping to opposite
        }
        evenCurrent.next = null; // to remove cycle
        oddCurrent.next = evenHead.next;
        return oddHead.next;
    }

    public ListNode oddEvenListOfficial(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
