import java.util.HashSet;
import java.util.Set;

public class P142 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public class Solution {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> nodes = new HashSet<>();
            while (head != null && !nodes.contains(head)) {
                nodes.add(head);
                head = head.next;

            }
            return head;
        }
    }
}
