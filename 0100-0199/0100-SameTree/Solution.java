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
    /**
     * Compares two binary trees iteratively by visiting matching positions together.
     * Null children are also queued so structural differences are detected naturally.
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.add(p);
        queue2.add(q);

        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            // Dequeue the next pair of nodes that should represent the same position.
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();

            // If only one node is null, the tree shapes differ.
            if (node1 == null || node2 == null) {
                if (node1 != node2) return false;
                continue;
            }

            // Matching positions must also store the same value.
            if (node1.val != node2.val) return false;

            // Queue both children, including nulls, to preserve structure comparison.
            queue1.add(node1.left);
            queue1.add(node1.right);
            queue2.add(node2.left);
            queue2.add(node2.right);
        }

        return queue1.isEmpty() && queue2.isEmpty();

    }
}
