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
    public void flatten(TreeNode root) {
        while(root != null) {
            // If root.left is not equal to null, we need to rebase it.
            if(root.left != null) {
                // Storing left and right subtrees
                TreeNode tempRight = root.right;
                TreeNode tempLeft = root.left;

                // Swapping
                root.right = root.left;
                root.left = null;

                // tempRight (right subtree of root) should be placed at the rightmost place of the tempLeft (left subtree of root)
                while(tempLeft.right != null) {
                    tempLeft = tempLeft.right;
                }

                tempLeft.right = tempRight;
            }
            root = root.right;
        }
    }
}