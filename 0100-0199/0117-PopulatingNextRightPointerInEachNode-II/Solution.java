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
        if (root == null) return root;

        // Dummy head used to build the next level's linked list.
        Node dummy = new Node(0);
        Node currentLevel = root;
        while (currentLevel != null) {
            Node tail = dummy;
            while (currentLevel != null) {
                // Link the left child into the next level if it exists.
                if (currentLevel.left != null) {
                    tail.next = currentLevel.left;
                    tail = tail.next;
                }

                // Link the right child immediately after the left child.
                if (currentLevel.right != null) {
                    tail.next = currentLevel.right;
                    tail = tail.next;
                }

                // Move across the current level using already established next pointers.
                currentLevel = currentLevel.next;
            }

            // Advance to the leftmost node of the next level and reset the builder.
            currentLevel = dummy.next;
            dummy.next = null;
        }
        return root;
    }
}
