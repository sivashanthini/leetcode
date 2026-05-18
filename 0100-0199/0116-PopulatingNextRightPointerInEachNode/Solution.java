/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return null;

        // Start from the leftmost node of each level.
        Node leftMost = root;
        while (leftMost.left != null) {
            Node curr = leftMost;
            while (curr != null) {
                // Connect the two children of the same parent.
                curr.left.next = curr.right;

                // Connect across adjacent parents using the current node's next pointer.
                if (curr.next != null) {
                    curr.right.next = curr.next.left;
                }

                // Move horizontally across the current level.
                curr = curr.next;
            }

            // Move down to the next level's leftmost node.
            leftMost = leftMost.left;
        }
        return root;
    }
}
