/*
 * LeetCode 70 - Climbing Stairs
 *
 * Problem:
 * You can climb either 1 or 2 steps at a time.
 * Find the number of distinct ways to reach the top.
 *
 * Example:
 * n = 3
 * Output = 3
 *
 * ------------------------------------------------------------
 * Initial Approach - Recursion
 * ------------------------------------------------------------
 *
 * To reach step n, we can come from:
 * 1. Step n - 1
 * 2. Step n - 2
 *
 * Therefore:
 *
 * ways(n) = ways(n - 1) + ways(n - 2)
 *
 * Base cases:
 * n == 0 -> 1 valid way
 * n < 0  -> 0 valid ways
 *
 * This recursive solution is logically correct, but it
 * recalculates the same subproblems many times.
 *
 * Time Complexity: O(2^n)
 * Space Complexity: O(n) due to recursion stack
 *
 * This approach resulted in Time Limit Exceeded.
 *
 * ------------------------------------------------------------
 * Optimized Approach - Iterative DP
 * ------------------------------------------------------------
 *
 * The recursive solution follows the Fibonacci pattern.
 *
 * Since the current answer only depends on the previous
 * two answers, we don't need to store the entire DP array.
 *
 * We keep:
 * prev2 = ways(n - 2)
 * prev1 = ways(n - 1)
 *
 * Then:
 * current = prev1 + prev2
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {

    // Initial recursive approach
    public int climbStairsRecursive(int n) {

        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        return climbStairsRecursive(n - 1)
                + climbStairsRecursive(n - 2);
    }

    // Optimized approach
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int prev2 = 1;
        int prev1 = 2;

        for (int i = 3; i <= n; i++) {

            int current = prev1 + prev2;

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}