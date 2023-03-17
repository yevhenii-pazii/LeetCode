import java.util.Objects;

public class P206 {

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


    ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        var result = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }

    //Add other options: stack, loop, any else?

    ListNode reverseListLoop(ListNode head) {
        if (head == null) return null;

        var mover = head;
        head = new ListNode(0, head);

        while (mover.next != null) {
            var currentHead = head.next;
            head.next =  mover.next;
            mover.next = mover.next.next;
            head.next.next = currentHead;
        }

        return head.next;
    }

    public ListNode reverseListOfficial(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

}