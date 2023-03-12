public class P141 {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this(x, null);
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(new P141().hasCycle(new ListNode(1)));
        System.out.println(new P141().hasCycle(new ListNode(1, new ListNode(2))));
        System.out.println(new P141().hasCycle(new ListNode(1, new ListNode(2, new ListNode(3)))));


        System.out.println();

        var head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        head.next.next.next.next = head.next;
        System.out.println(new P141().hasCycle(head));
    }

    public boolean hasCycle(ListNode head) {
        var slow = head;
        var fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
