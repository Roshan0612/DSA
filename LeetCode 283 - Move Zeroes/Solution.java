/**
 * LeetCode 283 - Move Zeroes
 *
 * Initial Approach:
 * - I first thought of keeping a pointer from the right side
 * pointing to a non-zero element.
 * - When I found a zero from the left, I would swap it with
 * the non-zero element from the right.
 *
 * Problem with the initial approach:
 * - The right pointer can become -1 when the array contains
 * only zeroes, causing an ArrayIndexOutOfBoundsException.
 * - Swapping from the right can also disturb the relative order
 * of the non-zero elements.
 *
 * Optimized Approach:
 * - Use two pointers.
 * - i scans the complete array.
 * - j represents the position where the next non-zero element
 * should be placed.
 * - Whenever nums[i] is non-zero, swap nums[i] with nums[j]
 * and move j forward.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public void moveZeroes(int[] nums) {

        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            // Found a non-zero element
            if (nums[i] != 0) {

                // Move the non-zero element to the next position
                // where a non-zero element should be placed.
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }
    }
}