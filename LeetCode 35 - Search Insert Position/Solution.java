/**
 * LeetCode 35 - Search Insert Position
 *
 * Initial Approach:
 * - Since the array is sorted, I first thought of traversing
 * the array from left to right.
 * - If nums[i] == target, return i.
 * - If nums[i] > target, the target should be inserted at i,
 * so return i.
 * - If we reach the end of the array, the target should be
 * inserted after the last element, so return nums.length.
 *
 * This approach is correct, but it takes O(n) time.
 *
 * Since the problem specifically requires O(log n) runtime
 * and the array is sorted, I optimized the solution using
 * Binary Search.
 *
 * Optimized Approach:
 * - Maintain left and right pointers.
 * - Calculate the middle index.
 * - If nums[mid] == target, return mid.
 * - If nums[mid] < target, search the right half.
 * - Otherwise, search the left half.
 *
 * When the search ends, left represents the correct position
 * where the target should be inserted.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

class Solution {

    // Initial approach - Linear Search
    public int searchInsertLinear(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] >= target) {
                return i;
            }
        }

        return nums.length;
    }

    // Optimized approach - Binary Search
    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}