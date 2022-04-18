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
    // a is the count of numbers passed in ascending order
    static int a = 0;
    static int result = 0;

    public int kthSmallest(TreeNode root, int k) {
        a = 0;
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode root, int k) {
        if(root == null) return;

        traverse(root.left, k);

        a++;
        if(a == k) result = root.val;

        traverse(root.right, k);
    }
}