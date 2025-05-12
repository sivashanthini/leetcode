/*
Shortest Subarray to be Removed to Make Array Sorted

Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.
Return the length of the shortest subarray to remove.
A subarray is a contiguous subsequence of the array.

Example 1:
Input: arr = [1,2,3,10,4,2,3,5]
Output: 3
Explanation: The shortest subarray we can remove is [10,4,2] of length 3. The remaining elements after that will be [1,2,3,3,5] which are sorted.
Another correct solution is to remove the subarray [3,10,4].

Example 2:
Input: arr = [5,4,3,2,1]
Output: 4
Explanation: Since the array is strictly decreasing, we can only keep a single element. Therefore we need to remove a subarray of length 4, either [5,4,3,2] or [4,3,2,1].

Example 3:
Input: arr = [1,2,3]
Output: 0
Explanation: The array is already non-decreasing. We do not need to remove any elements.

Constraints:
    1 <= arr.length <= 105
    0 <= arr[i] <= 109

Approach
1) Find the longest non-decreasing prefix from the beginning of the array. Let's call this left. This gives us the starting part of the array that’s already sorted.
2) Find the longest non-decreasing suffix from the end of the array. Let's call this right. This gives us the ending part of the array that’s already sorted.
3) Check if the entire array is sorted by verifying if left spans the whole array. If so, the answer is 0 because we don't need to remove anything.
4) Calculate minimum removal:
        Initially, consider removing either the entire suffix (n - left - 1 elements) or the entire prefix (right elements).
        Use a two-pointer technique to see if we can merge parts of the prefix and suffix by skipping the smallest possible middle section. This allows us to explore shorter subarrays to remove.
5) Return the result which is the minimum number of elements we need to remove.

 */

package array.medium;

public class ShortestSubArray_1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length, left = 0, right = n - 1;

        // Find the longest non-decreasing prefix from the left
        while (left + 1 < n && arr[left] <= arr[left + 1]) {
            left++;
        }

        // If the whole array is already non-decreasing, return 0
        if (left == n - 1) return 0;

        // Find the longest non-decreasing suffix from the right
        while (right > 0 && arr[right] >= arr[right - 1]) {
            right--;
        }

        // Minimum length to remove could be either:
        // - Removing all elements after 'left' (n - left - 1)
        // - Removing all elements before 'right' (right)
        int result = Math.min(right, n - left - 1);

        int i = 0, j = right;

        // Try to find a better answer by merging prefix and suffix
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                // If arr[i] can connect with arr[j], calculate removal length
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                // Otherwise, try the next element in the suffix
                j++;
            }
        }

        return result;
    }
}
