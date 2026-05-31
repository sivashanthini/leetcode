# 127. Word Ladder

- Difficulty: Hard
- Tags: Hash Table, String, Breadth-First Search

## Problem

A transformation sequence from `beginWord` to `endWord` using the dictionary `wordList` is a sequence:

`beginWord -> s1 -> s2 -> ... -> sk`

such that:

- every adjacent pair of words differs by exactly one letter,
- every `si` for `1 <= i <= k` is in `wordList`,
- `sk == endWord`.

Note that `beginWord` does not need to be in `wordList`.

Return the number of words in the shortest transformation sequence from `beginWord` to `endWord`, or `0` if no such sequence exists.

## Examples

### Example 1

Input: `beginWord = "hit"`, `endWord = "cog"`, `wordList = ["hot","dot","dog","lot","log","cog"]`  
Output: `5`  
Explanation: One shortest sequence is `hit -> hot -> dot -> dog -> cog`.

### Example 2

Input: `beginWord = "hit"`, `endWord = "cog"`, `wordList = ["hot","dot","dog","lot","log"]`  
Output: `0`  
Explanation: Since `cog` is not in `wordList`, no valid transformation exists.

## Constraints

- `1 <= beginWord.length <= 10`
- `endWord.length == beginWord.length`
- `1 <= wordList.length <= 5000`
- `wordList[i].length == beginWord.length`
- `beginWord`, `endWord`, and `wordList[i]` consist of lowercase English letters.
- `beginWord != endWord`
- All words in `wordList` are unique.

## Approach

This solution uses breadth-first search to find the shortest transformation:

- Put all dictionary words into a hash set for fast lookup.
- Start BFS from `beginWord`.
- For each word, try replacing each character with every lowercase letter.
- If a generated word exists in the set, add it to the queue and remove it from the set.
- The first time `endWord` is reached, return the current sequence length.

Because BFS explores level by level, the first valid path found is the shortest one.

## Complexity

- Time: `O(N * L * 26)`, where `N` is the number of words and `L` is the word length
- Space: `O(N)`
