/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Convert BST to Greater Tree <-- Same question, different (I think best) approach

    static int val = 0;
    public TreeNode bstToGst(TreeNode root) {
        val = 0;
        traverse(root);
        return root;
    }

    public void traverse(TreeNode root) {
        if(root == null) return;

        traverse(root.right);
        val += root.val;
        root.val = val;
        traverse(root.left);
    }
}