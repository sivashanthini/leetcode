/*
Given an array of integers arr, return true if we can partition the array into three non-empty parts with equal sums.
Formally, we can partition the array if we can find indexes i + 1 < j with (arr[0] + arr[1] + ... + arr[i] == arr[i + 1] + arr[i + 2] + ... + arr[j - 1] == arr[j] + arr[j + 1] + ... + arr[arr.length - 1])

Example 1:
Input: arr = [0,2,1,-6,6,-7,9,1,2,0,1]
Output: true
Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1

Example 2:
Input: arr = [0,2,1,-6,6,7,9,-1,2,0,1]
Output: false

Example 3:
Input: arr = [3,3,6,5,-2,2,5,1,-9,4]
Output: true
Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4



Constraints:
    3 <= arr.length <= 5 * 104
    -104 <= arr[i] <= 104
 */
package array.easy;

public class PartitionArrayThreePartsEqualSum_1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0, count = 0;

        // Step 1: Calculate the total sum of the array
        for (int num : arr) {
            sum += num;
        }

        // Step 2: Check if the sum is divisible by 3
        // If not, it's impossible to split the array into 3 equal parts
        if (sum % 3 != 0) return false;

        // Each part must sum to this value
        int avgSum = sum / 3;

        // Step 3: Traverse the array and look for subarrays that sum to avgSum
        int tempSum = 0;
        for (int num : arr) {
            tempSum += num;

            // Whenever a subarray with sum equal to avgSum is found
            // we reset tempSum and increase the count
            if (tempSum == avgSum) {
                count++;
                tempSum = 0;
            }
        }

        // Step 4: If we can find at least 3 such parts, return true
        // (It’s possible to have more than 3 subarrays summing to avgSum,
        // but we only need at least 3 to form 3 parts)
        return count >= 3;
    }


}
