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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return travel(root, low, high);
    }

    public int travel(TreeNode root, int low, int high) {
        if (root == null) return 0;

        else {
            int sum = 0;
            sum += root.val <= high && root.val >= low ? root.val : sum;

            if(root.val < high) {
                sum += travel(root.right, low, high);
            }

            if(root.val > low) {
                sum += travel(root.left, low, high);
            }

            return sum;
        }
    }
}