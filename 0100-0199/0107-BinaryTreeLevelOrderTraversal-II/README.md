# 107. Binary Tree Level Order Traversal II

- Difficulty: Medium
- Tags: Tree, Breadth-First Search, Binary Tree

## Problem

Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.

This means:
- traverse the tree level by level from left to right,
- but return the levels starting from the leaf level up to the root.

## Examples

### Example 1

![Example 1](images/img.png)

Input: `root = [3,9,20,null,null,15,7]`  
Output: `[[15,7],[9,20],[3]]`

### Example 2

Input: `root = [1]`  
Output: `[[1]]`

### Example 3

Input: `root = []`  
Output: `[]`

## Constraints

- The number of nodes in the tree is in the range `[0, 2000]`.
- `-1000 <= Node.val <= 1000`

## Approach

This solution uses breadth-first search with a queue:

- Traverse the tree in normal top-down level order.
- Store each level in a temporary list.
- After BFS finishes, iterate through the temporary list from the end to the beginning.
- Add those levels into the final result so the output becomes bottom-up.

## Complexity

- Time: `O(n)`
- Space: `O(n)`
