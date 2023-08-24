/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution
{
    public Node copyRandomList(Node head)
    {
        HashMap<Node,Node > map = new HashMap<Node,Node>();
        Node ptr=head;
        while(ptr!=null)
        {
            map.put(ptr,new Node(ptr.val));
            ptr=ptr.next;
        }
        ptr=head;
        while(ptr!=null)
        {
            map.get(ptr).next=map.get(ptr.next);
            map.get(ptr).random=map.get(ptr.random);
            ptr=ptr.next;
        }
        return map.get(head);
    }
}

