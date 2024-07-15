// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        int maxVal = 100001;  
        TreeNode[] nodes = new TreeNode[maxVal];
        int[] isChild = new int[maxVal];

        for (int[] description : descriptions) {
            int parentVal = description[0];
            int childVal  = description[1];
            int isLeft    = description[2];

            if (nodes[parentVal] == null) {
                nodes[parentVal] = new TreeNode(parentVal);
            }
            if (nodes[childVal] == null) {
                nodes[childVal] = new TreeNode(childVal);
            }

            if (isLeft == 1) {
                nodes[parentVal].left = nodes[childVal];
            } else {
                nodes[parentVal].right = nodes[childVal];
            }

            isChild[childVal] = 1;
        }

        TreeNode root = null;
        for (int i = 1; i < maxVal; i++) {
            if (nodes[i] != null && isChild[i]==0) {
                root = nodes[i];
                break;
            }
        }
        return root;
    }
}
