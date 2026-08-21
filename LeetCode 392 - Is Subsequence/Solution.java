/**
 * LeetCode 392 - Is Subsequence
 *
 * Initial Approach:
 * - I first thought of taking each character from s and searching
 * for it in t.
 * - Once a character is found, I would continue searching t from
 * the next position.
 * - The pointer for s should move only when its character is found.
 * - The pointer for t keeps moving forward every time.
 *
 * Optimization:
 * - Since we never need to move backward in t, we can use two
 * pointers instead of repeatedly searching.
 *
 * - i -> points to the current character of s
 * - j -> points to the current character of t
 *
 * - If s[i] == t[j], we found the required character, so move i.
 * - Regardless of whether they match, move j because we can never
 * use the same position in t again.
 *
 * - If i reaches the end of s, all characters of s were found
 * in the correct order.
 *
 * Example:
 * s = "abc"
 * t = "ahbgdc"
 *
 * a == a -> move i
 * b != h -> only move j
 * b == b -> move i
 * c != g -> only move j
 * c != d -> only move j
 * c == c -> move i
 *
 * i reaches s.length(), so return true.
 *
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean isSubsequence(String s, String t) {

        int i = 0; // Pointer for s
        int j = 0; // Pointer for t

        while (i < s.length() && j < t.length()) {

            // If characters match, move to the next character in s
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }

            // Always move forward in t
            j++;
        }

        // If all characters of s were found in order
        return i == s.length();
    }
}