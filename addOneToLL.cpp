class Solution
{
    public:
    Node* addOne(Node *head) 
    {
        // Reverse the linked list
        head = reverse(head);
        
        // Add one to the reversed list
        head = add(head);
        
        // Reverse the list again to restore the original order
        return reverse(head);
    }
    
    private:
    Node* reverse(Node* head)
    {
        Node* prev = NULL;
        Node* curr = head;
        Node* next = NULL;
        
        while (curr != NULL) {
            next = curr->next; // Store next node
            curr->next = prev; // Reverse current node's pointer
            prev = curr; // Move pointers one position ahead
            curr = next;
        }
        
        return prev; // New head of the reversed list
    }

    Node* add(Node* head)
    {
        int carry = 1;
        Node* temp = head;
        Node* prev = NULL;

        while (head != NULL)
        {
            int sum = head->data + carry;
            carry = (sum >= 10) ? 1 : 0;
            head->data = sum % 10;

            prev = head;
            head = head->next;
        }

        if (carry > 0) {
            prev->next = new Node(carry);
        }

        return temp;
    }
};
