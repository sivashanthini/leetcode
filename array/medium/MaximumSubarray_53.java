/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Constraints:
    1 <= nums.length <= 105
    -104 <= nums[i] <= 104

Kadane's Algorithm
The Intuition behind the code is to find the maximum sum of a contiguous subarray within the given array nums.
It does this by scanning through the array and keeping track of the current sum of the subarray.
Whenever the current sum becomes greater than the maximum sum encountered so far, it updates the maximum sum.
If the current sum becomes negative, it resets the sum to 0 and starts a new subarray.
By the end of the loop, the code returns the maximum sum found.
 */
package array.medium;

public class MaximumSubarray_53 {
    public int maxSubArray(int[] nums) {
        long maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible integer value
        long sum = 0;                    // Current running sum of subarray

        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];                          // Add current element to running sum
            maxSum = Math.max(maxSum, sum);          // Update maxSum if current sum is greater

            if (sum < 0) {
                sum = 0; // If running sum becomes negative, reset it to 0 (start new subarray)
            }
        }
        // Return the maximum subarray sum, cast back to int
        return (int) maxSum;
    }
}
