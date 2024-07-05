// #include <vector>

// using namespace std;

// struct ListNode {
//     int val;
//     ListNode *next;
//     ListNode() : val(0), next(nullptr) {}
//     ListNode(int x) : val(x), next(nullptr) {}
//     ListNode(int x, ListNode *next) : val(x), next(next) {}
// };

class Solution {
public:
    vector<int> nodesBetweenCriticalPoints(ListNode* head) {
        vector<int> points;
         if (!head || !head->next || !head->next->next) {
            points.push_back(-1);
            points.push_back(-1);
            return points;
        }
        ListNode* temp1 = head->next;
        ListNode* temp2 = head->next->next;
        ListNode* temp3 = head->next->next->next;
       int size = 1;
        vector<int> ans;
        while (temp3 != nullptr) {
            size++;
            if (size == 2) {
                if ((head->val > temp1->val && temp2->val > temp1->val) ||
                    (head->val < temp1->val && temp2->val < temp1->val)) {
                    ans.push_back(2);
                }
            } else {
                if ((temp1->val > temp2->val && temp3->val > temp2->val) ||
                    ((temp1->val < temp2->val && temp3->val < temp2->val))) {
                    ans.push_back(size);
                }
                temp1 = temp1->next;
                temp2 = temp2->next;
                temp3 = temp3->next;
            }
        }
        if (ans.size() < 2) {
            points.push_back(-1);
            points.push_back(-1);
            return points;
        }
        int minDistance = INT_MAX;
        int maxi = INT_MIN;
        int mini = INT_MAX;
        for (int i = 1; i < ans.size(); i++) {
            minDistance = min(minDistance, ans[i] - ans[i - 1]);
            maxi= max(maxi,ans[i]);
            mini = min(mini,ans[i]);
        }
        mini=min(mini,ans[0]);
        maxi=max(maxi,ans[0]);
        points.push_back(minDistance);
        points.push_back(maxi-mini);
        return points;
    }
};
