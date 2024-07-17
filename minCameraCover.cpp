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
class Solution {
public:
    int minCameraCover(TreeNode* root) {
        int cameras = 0;
        if (dfs(root, cameras) == -1) {
            cameras++;
        }
        return cameras;
    }

    int dfs(TreeNode* root, int &cameras) {
        if (root == nullptr) {
            return 1; // Node is null, no camera needed, already covered
        }

        int left = dfs(root->left, cameras);
        int right = dfs(root->right, cameras);

        if (left == -1 || right == -1) {
            cameras++;
            return 0; // Node has a camera
        }

        else if (left == 0 || right == 0) {
            return 1; // Node is covered
        }

        return -1; // Node requires a camera
    }
};
