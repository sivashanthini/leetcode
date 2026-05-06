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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        // Track the deepest level reached during breadth-first traversal.
        int max = 0;
        Queue<TreeNodeDist> queue = new LinkedList<>();

        // Start the root at depth 1 because depth counts nodes, not edges.
        queue.offer(new TreeNodeDist(1, root));
        while (!queue.isEmpty()) {
            // Remove the next node along with its current depth.
            TreeNodeDist nodeDist = queue.poll();
            TreeNode node = nodeDist.node;
            int d = nodeDist.dist;

            // Update the maximum depth seen so far.
            if (d > max) {
                max = d;
            }

            // Children are one level deeper than their parent.
            if (node.left != null) queue.offer(new TreeNodeDist(d+1, node.left));
            if (node.right != null) queue.offer(new TreeNodeDist(d+1, node.right));
        }
        return max;
    }

    public int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;

        // Compute the depth of both subtrees independently.
        int left = maxDepthRecursive(root.left);
        int right = maxDepthRecursive(root.right);

        // The current node contributes one level above the deeper subtree.
        return Math.max(left, right) + 1;
    }
}

class TreeNodeDist {
    int dist;
    TreeNode node;
    TreeNodeDist(int dist, TreeNode node) {
        this.node = node;
        this.dist = dist;
    }
}
