/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].



Constraints:
    1 <= digits.length <= 100
    0 <= digits[i] <= 9
    digits does not contain any leading 0's.
 */
package array.easy;

public class PlusOne_66 {
    // This method adds 1 to a number represented by an array of digits
    public int[] plusOne(int[] digits) {

        // Create a result array with one extra digit in case of carry overflow (e.g., 999 + 1 = 1000)
        int[] result = new int[digits.length + 1];

        // `len` tracks the current position in the result array (starting from the last index)
        int len = digits.length;

        // `rem` is the carry, initialized to 1 because we're adding 1
        int rem = 1;

        // Traverse the input array from the end (least significant digit)
        for (int i = digits.length - 1; i >= 0; i--) {
            int num = digits[i] + rem; // Add the digit and the carry

            if (num > 9) {
                result[len--] = 0; // If sum is 10, store 0 and carry over 1
                rem = 1;
            } else {
                result[len--] = num; // If sum is less than 10, store the result and reset carry
                rem = 0;
            }
        }

        // If carry is still left after processing all digits, place it at the beginning
        if (rem == 1)
            result[len] = 1;

        // If the most significant digit is 0 (no carry overflow), skip it and return the rest
        if (result[0] == 0) {
            // Shift the result array one position left to ignore the leading 0
            for (int i = 1; i < result.length; i++)
                digits[i - 1] = result[i]; // Overwrite input array to save memory (not strictly necessary)
            return digits; // Return the original array (now filled with the correct digits)
        }

        // If there's a carry overflow, return the full result (e.g., [1,0,0,0])
        return result;
    }

}
