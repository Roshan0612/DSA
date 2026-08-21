/**
 * LeetCode 374 - Guess Number Higher or Lower
 *
 * Initial Understanding:
 * - At first, I was confused about what exactly I had to implement
 * because the problem already gives the guess(int num) function.
 *
 * - Then I understood that guess() is a predefined API provided
 * by LeetCode. I only need to call it with my current guess.
 *
 * The guess() API returns:
 *
 * 0 -> My guess is correct.
 * 1 -> My guess is LOWER than the picked number.
 * -1 -> My guess is HIGHER than the picked number.
 *
 * Example:
 *
 * pick = 7
 * mid = 5
 *
 * guess(5) returns 1
 * because 5 is lower than 7.
 *
 * Therefore, the picked number must be on the RIGHT side,
 * so we move:
 *
 * left = mid + 1
 *
 * Another example:
 *
 * pick = 7
 * mid = 8
 *
 * guess(8) returns -1
 * because 8 is higher than 7.
 *
 * Therefore, the picked number must be on the LEFT side,
 * so we move:
 *
 * right = mid - 1
 *
 * Optimized Approach:
 * - Since the API tells us whether our guess is lower or higher,
 * we can eliminate half of the possible numbers after every guess.
 * - This makes Binary Search the natural approach.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class Solution extends GuessGame {

    public int guessNumber(int n) {

        int left = 1;
        int right = n;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int result = guess(mid);

            /*
             * result == 0 means:
             * Our guess is exactly the picked number.
             */
            if (result == 0) {
                return mid;
            }

            /*
             * result == 1 means:
             * Our guess is LOWER than the picked number.
             *
             * Example:
             * pick = 7
             * mid = 5
             *
             * guess(5) -> 1
             *
             * So the answer must be somewhere to the RIGHT.
             */
            if (result == 1) {
                left = mid + 1;
            }

            /*
             * result == -1 means:
             * Our guess is HIGHER than the picked number.
             *
             * Example:
             * pick = 7
             * mid = 8
             *
             * guess(8) -> -1
             *
             * So the answer must be somewhere to the LEFT.
             */
            else {
                right = mid - 1;
            }
        }

        return -1;
    }
}