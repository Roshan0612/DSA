/*
 * LeetCode 2544 - Alternating Digit Sum
 *
 * Problem:
 * Given a positive integer n, assign alternating signs to its digits.
 * The most significant digit starts with a positive sign.
 *
 * Example:
 *
 * n = 521
 *
 * (+5) + (-2) + (+1) = 4
 *
 *
 * ---------------------------------------------------------
 * APPROACH 1: PROCESS THE NUMBER USING % 10 AND / 10
 * ---------------------------------------------------------
 *
 * My first thought was to process the number digit by digit.
 *
 * We can get the last digit using:
 *
 *     n % 10
 *
 * and remove the last digit using:
 *
 *     n / 10
 *
 * For example:
 *
 *     521 % 10 = 1
 *     521 / 10 = 52
 *
 * So we can keep extracting digits until n becomes 0.
 *
 * I also need a sign variable:
 *
 *     +1 -> add the digit
 *     -1 -> subtract the digit
 *
 * The problem is that % 10 gives us the digits from RIGHT to LEFT,
 * while the problem assigns signs from LEFT to RIGHT.
 *
 * Example:
 *
 *     1347
 *
 * Required:
 *
 *     +1 -3 +4 -7 = -5
 *
 * But % 10 gives:
 *
 *     7 -> 4 -> 3 -> 1
 *
 * If I simply start with +1, I get:
 *
 *     +7 -4 +3 -1 = 5
 *
 * So the starting sign cannot always be +1.
 *
 *
 * ---------------------------------------------------------
 * OBSERVATION: NUMBER OF DIGITS
 * ---------------------------------------------------------
 *
 * The sign of the RIGHTMOST digit depends on the number of digits.
 *
 * If the number has an ODD number of digits:
 *
 *     521
 *
 *     +5 -2 +1
 *
 * The rightmost digit is positive.
 *
 * Therefore, while processing from right to left:
 *
 *     1 -> +1
 *     2 -> -2
 *     5 -> +5
 *
 *
 * If the number has an EVEN number of digits:
 *
 *     1347
 *
 *     +1 -3 +4 -7
 *
 * The rightmost digit is negative.
 *
 * Therefore:
 *
 *     7 -> -7
 *     4 -> +4
 *     3 -> -3
 *     1 -> +1
 *
 * So:
 *
 *     odd number of digits  -> start with +
 *     even number of digits -> start with -
 *
 *
 * ---------------------------------------------------------
 * FINDING THE NUMBER OF DIGITS
 * ---------------------------------------------------------
 *
 * We can count the digits by repeatedly dividing by 10.
 *
 *     1347 -> 134 -> 13 -> 1 -> 0
 *
 * This takes O(log n) time because the number of digits itself
 * is O(log n).
 *
 * For this problem n <= 10^9, so there are at most 10 digits.
 *
 *
 * ---------------------------------------------------------
 * APPROACH 2: STRING APPROACH
 * ---------------------------------------------------------
 *
 * After thinking about the problem, there is an even simpler way.
 *
 * The problem wants us to process digits from LEFT to RIGHT.
 *
 * A String naturally gives us the digits in that order.
 *
 * So instead of:
 *
 *     % 10
 *     / 10
 *     count digits
 *     decide the starting sign
 *
 * we can simply convert n into a String and iterate from left to right.
 *
 * Example:
 *
 *     n = 1347
 *
 *     String = "1347"
 *
 *     1 -> +
 *     3 -> -
 *     4 -> +
 *     7 -> -
 *
 *     1 - 3 + 4 - 7 = -5
 *
 * We start sign with +1 because the problem says that the most
 * significant digit must always have a positive sign.
 *
 * After processing every digit, we multiply sign by -1 to
 * alternate between positive and negative.
 *
 *
 * ---------------------------------------------------------
 * FINAL APPROACH: STRING
 * ---------------------------------------------------------
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(log n)
 *
 * The String solution is cleaner because it directly follows
 * the direction in which the problem defines the signs.
 */

class Solution {

    public int alternateDigitSum(int n) {

        String number = String.valueOf(n);

        int answer = 0;
        int sign = 1;

        for (int i = 0; i < number.length(); i++) {

            int digit = number.charAt(i) - '0';

            answer += digit * sign;

            sign *= -1;
        }

        return answer;
    }
}