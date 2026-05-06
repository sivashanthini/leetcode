# 102. Binary Tree Level Order Traversal

- Difficulty: Medium
- Tags: Tree, Breadth-First Search, Binary Tree

## Problem

Given the root of a binary tree, return the level order traversal of its nodes' values from left to right, level by level.

## Examples

### Example 1

![Example 1](images/img.png)

Input: `root = [3,9,20,null,null,15,7]`  
Output: `[[3],[9,20],[15,7]]`

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

- Start by adding the root node to the queue.
- For each iteration, record the current queue size to know how many nodes belong to the current level.
- Remove exactly that many nodes, collect their values, and add their children to the queue.
- Append the collected values for each level to the final result.

## Complexity

- Time: `O(n)`
- Space: `O(n)`
