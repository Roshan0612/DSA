/*
 * LeetCode 258 - Add Digits
 *
 * Problem:
 * Given a non-negative integer num, repeatedly add all its digits
 * until the result has only one digit.
 *
 * Example:
 *
 *     12345
 *     -> 1 + 2 + 3 + 4 + 5
 *     -> 15
 *     -> 1 + 5
 *     -> 6
 *
 * Answer: 6
 *
 *
 * ---------------------------------------------------------
 * APPROACH 1: REPEATED DIGIT SUM
 * ---------------------------------------------------------
 *
 * My first thought was to solve the problem directly using loops.
 *
 * I can extract the last digit using:
 *
 *     num % 10
 *
 * and remove the last digit using:
 *
 *     num / 10
 *
 * So for every number, I calculate the sum of its digits.
 * If the sum still has more than one digit, I repeat the process.
 *
 * Example:
 *
 *     12345
 *     -> 15
 *     -> 6
 *
 * Time Complexity: O(log10(n))
 * Space Complexity: O(1)
 */

class Solution {

    public int addDigitsLoop(int num) {

        while (num > 9) {

            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            num = sum;
        }

        return num;
    }

    /*
     * ---------------------------------------------------------
     * APPROACH 2: DIGITAL ROOT / MATHEMATICAL APPROACH
     * ---------------------------------------------------------
     *
     * The repeated digit-sum process is called the Digital Root.
     *
     * Instead of actually performing the repeated digit sum,
     * we can calculate the result directly using modulo 9.
     *
     *
     * WHY MODULO 9?
     *
     * We normally work in base 10.
     *
     * 10 = 9 + 1
     *
     * Therefore:
     *
     * 10 ≡ 1 (mod 9)
     *
     * This also means:
     *
     * 10² ≡ 1 (mod 9)
     * 10³ ≡ 1 (mod 9)
     * 10⁴ ≡ 1 (mod 9)
     *
     * Consider:
     *
     * 12345
     *
     * = 1 × 10⁴
     * + 2 × 10³
     * + 3 × 10²
     * + 4 × 10
     * + 5
     *
     * Since every power of 10 is equivalent to 1 modulo 9:
     *
     * 12345 ≡ 1 + 2 + 3 + 4 + 5 (mod 9)
     *
     * Therefore, a number and its digit sum have the same
     * remainder when divided by 9.
     *
     * This means we can skip the repeated digit-sum process.
     *
     *
     * ---------------------------------------------------------
     * WHY NOT SIMPLY USE num % 9?
     * ---------------------------------------------------------
     *
     * There is one special case.
     *
     * 9 % 9 = 0
     * 18 % 9 = 0
     * 27 % 9 = 0
     *
     * But their digital root is 9, not 0.
     *
     * So we use:
     *
     * 1 + ((num - 1) % 9)
     *
     * The (num - 1) and +1 shift the result from:
     *
     * 0,1,2,3,4,5,6,7,8
     *
     * to:
     *
     * 1,2,3,4,5,6,7,8,9
     *
     *
     * ---------------------------------------------------------
     * DIGITAL ROOT FORMULA
     * ---------------------------------------------------------
     *
     * For num > 0:
     *
     * digital root = 1 + ((num - 1) % 9)
     *
     * For num = 0:
     *
     * digital root = 0
     *
     *
     * Example:
     *
     * num = 12345
     *
     * 1 + ((12345 - 1) % 9)
     * = 1 + (12344 % 9)
     * = 1 + 5
     * = 6
     *
     *
     * ---------------------------------------------------------
     * GENERALIZATION
     * ---------------------------------------------------------
     *
     * The same idea works for any number base b.
     *
     * In base 10:
     *
     * b = 10
     * b - 1 = 9
     *
     * In general:
     *
     * b ≡ 1 (mod b - 1)
     *
     * Therefore:
     *
     * b^i ≡ 1 (mod b - 1)
     *
     * This is why the digit values can be added together when
     * calculating the remainder modulo (b - 1).
     *
     *
     * ---------------------------------------------------------
     * COMPLEXITY
     * ---------------------------------------------------------
     *
     * Time Complexity: O(1)
     * Space Complexity: O(1)
     *
     * This is better than repeatedly calculating digit sums
     * because the entire process is replaced by one formula.
     */

    public int addDigits(int num) {

        if (num == 0) {
            return 0;
        }

        return 1 + (num - 1) % 9;
    }
}