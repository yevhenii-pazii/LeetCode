package problem.p0000_0099;

import structure.ListNode;

class P21 {

    /*
        Time Complexity O(N)
        Space Complexity O(N)
        N - Length of both lists
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    /*
        Time Complexity O(N)
        Space Complexity O(1)
        N - Length of both lists
     */
    public ListNode mergeTwoListsLoop(ListNode list1, ListNode list2) {
        var sentinel = new ListNode(0);
        var merge = sentinel;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                merge.next = list1;
                list1 = list1.next;
            } else {
                merge.next = list2;
                list2 = list2.next;
            }
            merge = merge.next;
        }

        merge.next = list1 == null ? list2 : list1;
        return sentinel.next;
    }
}
