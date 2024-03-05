public class Solution {
    public static Node flattenLinkedList(Node head) {
        // Write your code here
        if (head == null || head.next == null) return head;
        Node mergedHead = flattenLinkedList(head.next);
        return merge(head, mergedHead);
    }

private static Node merge(Node l1, Node l2) {
    Node dummy = new Node(-1);
    Node ptr = dummy;
    
    while (l1 != null && l2 != null) {
        if (l1.data < l2.data) {
            ptr.child = l1;
            l1 = l1.child;
        } else {
            ptr.child = l2;
            l2 = l2.child;
        }
        ptr = ptr.child;
    }

    if (l1 != null) {
        ptr.child = l1;
    } else {
        ptr.child = l2;
    }

    return dummy.child;
}

}
