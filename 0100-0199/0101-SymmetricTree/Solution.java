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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            // Dequeue the next pair of nodes that should mirror each other.
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            // If only one side is null, the tree is not symmetric.
            if (left == null || right == null) {
                if (left != right) return false;
                continue;
            }

            // Mirrored nodes must carry the same value.
            if (left.val != right.val) return false;

            // Enqueue children in mirror order for the next comparison.
            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        if (root == null) return true;

        // A tree is symmetric when its left and right subtrees are mirrors.
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        // Two empty nodes mirror each other.
        if (left == null && right == null) return true;

        // If only one node is empty, the mirror structure breaks.
        if (left == null || right == null) return false;

        // Values must match, and outer/inner children must mirror recursively.
        return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
