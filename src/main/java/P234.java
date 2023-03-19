import java.util.Deque;
import java.util.LinkedList;

public class P234 {

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

    //V1 better than just having a list and number of operations is
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;

        var fast = head;
        var slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow = slow.next; //need an additional step

        Deque<Integer> stack = new LinkedList<>();
        while (slow != null) {
            stack.push(slow.val);
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != head.val) {
                return false;
            }
            head = head.next;
        }

        return true;
    }

    public boolean isPalindromeNoExtraSpace(ListNode head) {
        if (head == null) return false;

        var fast = head;
        var slow = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        var secondHalfHead = reverse(slow.next);
        var second = secondHalfHead;

        while (second != null) {
            if (second.val != head.val) {
                reverse(secondHalfHead);
                return false;
            }
            second = second.next;
            head = head.next;
        }

        reverse(secondHalfHead);
        return true;
    }

    private static ListNode reverse(ListNode node) {
        ListNode previous = null;
        var current = node;

        while (current != null) {
            var tempNext = current.next;
            current.next = previous;
            previous = current;
            current = tempNext;
        }

        return previous;
    }
}
