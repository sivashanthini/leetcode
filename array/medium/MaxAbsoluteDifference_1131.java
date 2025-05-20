/*
Given two arrays of integers with equal lengths, return the maximum value of:
|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
where the maximum is taken over all 0 <= i, j < arr1.length.

Example 1:
Input: arr1 = [1,2,3,4], arr2 = [-1,4,5,6]
Output: 13

Example 2:
Input: arr1 = [1,-2,-5,0,10], arr2 = [0,-2,-1,-7,-4]
Output: 20

Constraints:
    2 <= arr1.length == arr2.length <= 40000
    -10^6 <= arr1[i], arr2[i] <= 10^6

Explanation
abs(A) + abs(B) = max(A+B, A-B, -A+B, -A-B)
abs(A) + abs(B) + abs(C) = max {
 									 (a + b + c),
 									 (a + b - c),
 									 (a - b + c),
 									 (a - b - c),
 									 (-a + b + c), => -(a - b - c)
 									 (-a + b - c), => -(a - b + c)
 									 (-a - b + c), => -(a + b - c)
 									 (-a - b - c)  => -(a + b + c)
 								 }
a = (arr1[i] - arr2[i])
b = (arr1[j] - arr2[j])
c = i - j

{(+/-) arr1[i]  (+/-) arr2[i] (+/-) i } -
{(+/-) arr1[j]  (+/-) arr2[j] (+/-) j }
 */
package array.medium;

public class MaxAbsoluteDifference_1131 {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, max4 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, min3 = Integer.MAX_VALUE, min4 = Integer.MAX_VALUE;
        for (int i = 0; i < arr1.length; i++) {
            // Track the max and min of the expression: arr1[i] + arr2[i] + i
            max1 = Math.max(max1, arr1[i] + arr2[i] + i);
            min1 = Math.min(min1, arr1[i] + arr2[i] + i);

            // Track the max and min of the expression: arr1[i] + arr2[i] - i
            max2 = Math.max(max2, arr1[i] + arr2[i] - i);
            min2 = Math.min(min2, arr1[i] + arr2[i] - i);

            // Track the max and min of the expression: arr1[i] - arr2[i] + i
            max3 = Math.max(max3, arr1[i] - arr2[i] + i);
            min3 = Math.min(min3, arr1[i] - arr2[i] + i);

            // Track the max and min of the expression: arr1[i] - arr2[i] - i
            max4 = Math.max(max4, arr1[i] - arr2[i] - i);
            min4 = Math.min(min4, arr1[i] - arr2[i] - i);
        }
        // The maximum absolute value expression result will be the largest difference
        // between max and min for each of the 4 possible expressions
        return Math.max(Math.max(max1 - min1, max2 - min2), Math.max(max3 - min3, max4 - min4));
    }

}
