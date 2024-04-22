package problem.p0200_0299;

class P203 {

    static class ListNode {
        int val;
        P203.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, P203.ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + "val=" + val + ", next=" + next + '}';
        }
    }

    //My solution
    public ListNode removeElements(ListNode head, int val) {
        head = new ListNode(0, head); //sentinel node
        var current = head;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head.next;
    }

    //My solution
    public ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) {
            return removeElementsRecursive(head.next, val);
        } else {
            head.next = removeElementsRecursive(head.next, val);
            return head;
        }
    }

    public ListNode removeElementsRecursiveFromSolutions(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return (head.val == val) ? head.next : head;
    }
}
