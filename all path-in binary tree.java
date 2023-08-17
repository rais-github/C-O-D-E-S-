import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            generatePaths(root, "", paths);
        }
        return paths;
    }
    
    private void generatePaths(TreeNode node, String currentPath, List<String> paths) {
        if (node.left == null && node.right == null) {
            paths.add(currentPath + node.val);
            return;
        }
        
        if (node.left != null) {
            generatePaths(node.left, currentPath + node.val + "->", paths);
        }
        
        if (node.right != null) {
            generatePaths(node.right, currentPath + node.val + "->", paths);
        }
    }
}
