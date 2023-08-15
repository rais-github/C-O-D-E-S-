class Solution {
    public ListNode doubleIt(ListNode head) {
        if (head == null) {
            return null;
        }

        // Reverse the linked list
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Double the values and handle carry
        current = prev;
        int carry = 0;
        while (current != null) {
            int newValue = current.val * 2 + carry;
            carry = newValue / 10;
            current.val = newValue % 10;
            current = current.next;
        }

        // Reverse the linked list back to its original order
        ListNode newHead = null;
        current = prev;
        while (current != null) {
            ListNode next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }

        // Handle any remaining carry
        if (carry > 0) {
            ListNode carryNode = new ListNode(carry);
            carryNode.next = newHead;
            newHead = carryNode;
        }

        return newHead;
    }
}
