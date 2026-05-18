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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, result);
        return result;
    }

    private void dfs(TreeNode node, int remainingSum, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        // Add the current node to the path before exploring deeper.
        path.add(node.val);
        remainingSum -= node.val;

        // A valid path must end at a leaf exactly when the remaining sum becomes zero.
        if (node.left == null && node.right == null && remainingSum == 0) {
            result.add(new ArrayList<>(path));
        } else {
            // Continue exploring both subtrees with the reduced target.
            dfs(node.left, remainingSum, path, result);
            dfs(node.right, remainingSum, path, result);
        }

        // Backtrack so the parent call can reuse the path list.
        path.remove(path.size() - 1);
    }
}
