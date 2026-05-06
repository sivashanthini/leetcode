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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // true means left-to-right for this level, false means right-to-left.
        boolean dir = true;
        while (!queue.isEmpty()) {
            // Record how many nodes belong to the current level.
            int size = queue.size();

            // Collect values for one level before applying zigzag ordering.
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                // Queue the next level in normal BFS order.
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Reverse every other level to create the zigzag pattern.
            if (dir) result.add(list);
            else {
                Collections.reverse(list);
                result.add(list);
            }

            // Flip the direction for the next level.
            dir = !dir;
        }
        return result;
    }
}
