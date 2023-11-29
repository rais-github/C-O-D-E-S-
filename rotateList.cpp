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
    ListNode* rotateRight(ListNode* head, int k) {
        if (k == 0 || head == nullptr || head->next == nullptr) return head;
        ListNode* ptr = head, *last = head, *cur = head;
        int size = 0;
        while (ptr != nullptr) {
            ptr = ptr->next;
            size++;
        }
        k = k % size;
        while (k--) {
            while (cur->next != nullptr) {
                last = cur;
                cur = cur->next;
            }
            last->next = nullptr;
            cur->next = head;
            head = cur;
        }
        return head;
    }
};
