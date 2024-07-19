/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* temp = head;
        ListNode* nxt = NULL;
        ListNode* prev = NULL;        
        while (temp != NULL) {
            ListNode* kthNode = findNode(temp, k);
            if (kthNode == NULL) {
                if (prev != NULL) prev->next = temp;
                break;
            }
            nxt = kthNode->next;
            kthNode->next=NULL;
            reverse(temp, kthNode);
            if (head==temp) {
                head = kthNode;
            } else {
                prev->next = kthNode;
            }
            prev = temp;
            temp = nxt;
        }
        return head;
    }
private:
    ListNode* findNode(ListNode* temp, int k) {
        while (--k > 0 && temp != NULL) {
            temp = temp->next;
        }
        return temp;
    }
    void reverse(ListNode* start, ListNode* end) {
        ListNode* prev = NULL;
        ListNode* curr = start;
        ListNode* next = NULL;
        while (curr != end) {
            next = curr->next;
            curr->next = prev;
            prev = curr;
            curr = next;
        }
        curr->next = prev; //
    }
};
