class Solution {

     int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        }
        if(low <= root.val && root.val <= high) {
            sum += root.val;
        }
        if(root.val > low) {
            rangeSumBST(root.left, low, high);
        }
        if(root.val < high) {
            rangeSumBST(root.right, low, high);
        }
        return sum;
    }
}
