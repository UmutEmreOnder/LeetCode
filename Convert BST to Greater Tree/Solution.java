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
    static int sum = 0;
    static int index = 0;

    public TreeNode convertBST(TreeNode root) {
        sum = 0;
        index = 0;

        // Add values of root to a list in ascending order
        List<Integer> nodeList = new ArrayList<>();
        traverse(nodeList, root);

        /*
        Edit the linkedlist
        sum = 36, nodeList.get(0) = 0 -> sum = 36, nodeList.get(0) = 36
        sum = 36, nodeList.get(1) = 1 -> sum = 35, nodeList.get(1) = 36
        sum = 35, nodeLIst.get(2) = 2 -> sum = 33, nodeList.get(2) = 35
        ....
         */
        for(int i = 0; i < nodeList.size(); i++) {
            sum -= nodeList.get(i);
            nodeList.set(i, sum + nodeList.get(i));
        }

        // Edit the tree with the nodeList
        traverseAndEdit(nodeList, root);
        return root;
    }

    public void traverse(List<Integer> nodeList, TreeNode root) {
        if(root == null) return;
        // While adding values to the list, find the sum off all elements
        sum += root.val;

        traverse(nodeList, root.left);
        nodeList.add(root.val);
        traverse(nodeList, root.right);
    }

    public void traverseAndEdit(List<Integer> nodeList, TreeNode root) {
        if(root == null) return;

        traverseAndEdit(nodeList, root.left);
        root.val = nodeList.get(index++);
        traverseAndEdit(nodeList, root.right);
    }
}