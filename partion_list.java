/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small=null;
        ListNode large=null;
        ListNode s=null,l=null;
        while(head!=null)
        {
            if(head.val<x)
            {
                if(small==null)
                {
                    small=head;
                    s=head;
                }
                else
                {
                    s.next=head;
                    s=s.next;
                }

            }
            else
            {
                if(large==null)
                {
                    large=head;
                    l=head;
                }
                else
                {
                    l.next=head;
                    l=l.next;
                }
            }
            head=head.next;
        }
        if(s!=null) s.next=large;
        if(l!=null) l.next=null;
        if(small!=null) return small;
        return large;
    }
}