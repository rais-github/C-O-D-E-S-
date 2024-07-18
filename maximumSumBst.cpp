/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class BstPair {
public:
    int min;
    int max;
    bool isBst;
    int sum;
    int ans;

    BstPair() : min(INT_MAX), max(INT_MIN), isBst(true), sum(0), ans(0) {}
};

class Solution {
public:
    int maxSumBST(TreeNode* root) {
        return subBstSumMax(root).ans;
    }

private:
    BstPair subBstSumMax(TreeNode* root) {
        if (root == nullptr) return BstPair();
        
        BstPair lbp = subBstSumMax(root->left);
        BstPair rbp = subBstSumMax(root->right);
        BstPair sbp;
        
        sbp.sum = lbp.sum + rbp.sum + root->val;
        sbp.isBst = lbp.isBst && rbp.isBst && lbp.max < root->val && rbp.min > root->val;
        sbp.min = min(root->val, min(lbp.min, rbp.min));
        sbp.max = max(root->val, max(lbp.max, rbp.max));
        sbp.ans = max(sbp.ans, max(lbp.ans, rbp.ans));
        if (sbp.isBst) {
            sbp.ans = max(sbp.ans, sbp.sum);
        }
        return sbp;
    }
};
