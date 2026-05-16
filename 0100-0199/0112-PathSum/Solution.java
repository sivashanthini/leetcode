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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        // Subtract the current node value so children only need to satisfy the remaining sum.
        int remSum = targetSum - root.val;

        // A root-to-leaf path matches only if the remaining sum becomes zero at a leaf.
        if (root.left == null && root.right == null) return remSum == 0;

        // Continue searching either subtree with the reduced target.
        return hasPathSum(root.left, remSum) || hasPathSum(root.right, remSum);
    }

    public boolean hasPathSumBFS(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<TreeNodeWithSum> queue = new LinkedList<>();

        // Start BFS with the root and the path sum accumulated so far.
        queue.offer(new TreeNodeWithSum(root, root.val));
        while (!queue.isEmpty()) {
            TreeNodeWithSum nodeWithSum = queue.poll();
            TreeNode node = nodeWithSum.node;
            int pathSum = nodeWithSum.sum;

            // A leaf contributes a valid answer only when its full root-to-leaf sum matches the target.
            if (node.left == null && node.right == null && pathSum == targetSum) {
                return true;
            }

            // Extend the current path sum when exploring the next level.
            if (node.left != null) queue.offer(new TreeNodeWithSum(node.left, pathSum + node.left.val));
            if (node.right != null) queue.offer(new TreeNodeWithSum(node.right, pathSum + node.right.val));
        }
        return false;
    }
}

class TreeNodeWithSum {
    int sum;
    TreeNode node;
    TreeNodeWithSum(TreeNode node, int sum) {
        this.node = node;
        this.sum = sum;
    }
}
