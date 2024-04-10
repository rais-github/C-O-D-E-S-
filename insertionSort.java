public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = head, curr = head.next;

        while (curr != null) {
            if (curr.val >= prev.val) {
                prev = curr;
                curr = curr.next;
            } else {
                ListNode ptr = dummy;
                while (ptr.next != null && curr.val > ptr.next.val) {
                    ptr = ptr.next;
                }
                prev.next = curr.next;
                curr.next = ptr.next;
                ptr.next = curr;
                curr = prev.next;
            }
        }
        return dummy.next;
    }
}
