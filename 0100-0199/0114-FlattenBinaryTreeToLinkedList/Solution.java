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
        if (root == null) return;
        TreeNode current = root;
        while (current != null) {
            if (current.left != null) {
                // Find the rightmost node in the current node's left subtree.
                TreeNode last = current.left;
                while (last.right != null) {
                    last = last.right;
                }

                // Attach the original right subtree after that rightmost node.
                last.right = current.right;

                // Move the entire left subtree to the right and clear the left pointer.
                current.right = current.left;
                current.left = null;
            }

            // Continue along the flattened right-side chain.
            current = current.right;
        }
    }
}
