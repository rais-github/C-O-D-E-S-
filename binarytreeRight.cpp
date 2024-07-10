    /**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        vector<int> res;
        int maxDepth = -1;
        view(root, 0, maxDepth, res);
        return res;
    }
    void view(TreeNode* root, int currentDepth, int& maxDepth,
              vector<int>& res) {
        if (root == nullptr) {
            return;
        }

        if (currentDepth > maxDepth) {
            res.push_back(root->val);
            maxDepth = currentDepth;
        }
        view(root->right, currentDepth + 1, maxDepth, res);
        view(root->left, currentDepth + 1, maxDepth, res);
    }
};
