/*
 * LeetCode 217 - Contains Duplicate
 *
 * Problem:
 * Given an integer array nums, return true if any value appears at least twice.
 * Return false if every element is distinct.
 *
 * ---------------------------------------------------------
 * APPROACH 1: XOR OPERATION
 * ---------------------------------------------------------
 *
 * My first thought was to use XOR because:
 *
 *     x ^ x = 0
 *     x ^ 0 = x
 *
 * XOR also gives O(1) extra space and O(n) time.
 *
 * However, after thinking about the problem, XOR does NOT work here.
 *
 * Example:
 *
 *     nums = [1, 1, 2, 2]
 *
 *     1 ^ 1 ^ 2 ^ 2 = 0
 *
 * We cannot determine from this result whether duplicates exist.
 *
 * Also:
 *
 *     nums = [1, 2, 3]
 *
 * XOR can also produce a value that doesn't tell us whether duplicates
 * exist.
 *
 * Therefore, XOR is NOT suitable for this problem.
 *
 *
 * ---------------------------------------------------------
 * APPROACH 2: HASHMAP / FREQUENCY COUNT
 * ---------------------------------------------------------
 *
 * The next idea was to store every number and its frequency.
 *
 * Example:
 *
 *     nums = [1, 2, 3, 1]
 *
 *     1 -> 2
 *     2 -> 1
 *     3 -> 1
 *
 * After building the map, we can check if any value has a count > 1.
 *
 * Java implementation:
 *
 *     HashMap<Integer, Integer> map = new HashMap<>();
 *
 *     for (int num : nums) {
 *         map.put(num, map.getOrDefault(num, 0) + 1);
 *     }
 *
 *     for (int count : map.values()) {
 *         if (count > 1) {
 *             return true;
 *         }
 *     }
 *
 *     return false;
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * This works, but there is unnecessary work because we don't actually
 * need to know the frequency of every number.
 *
 *
 * ---------------------------------------------------------
 * APPROACH 3: ARRAY FOR FREQUENCY
 * ---------------------------------------------------------
 *
 * I also considered using an array instead of a HashMap to store counts.
 *
 * However, nums[i] can be as small as -10^9 and as large as 10^9.
 *
 * Therefore, we cannot directly use nums[i] as an array index.
 *
 * We would either need to transform/compress the values or allocate
 * an extremely large array, which is impractical.
 *
 * So this is not a good solution for the given constraints.
 *
 *
 * ---------------------------------------------------------
 * APPROACH 4: SORTING
 * ---------------------------------------------------------
 *
 * Another possible solution is to sort the array.
 *
 * Once sorted, duplicate values will be next to each other.
 *
 * Example:
 *
 *     [3, 1, 4, 1, 2]
 *
 *     After sorting:
 *
 *     [1, 1, 2, 3, 4]
 *
 *     nums[i] == nums[i - 1]
 *
 * means a duplicate exists.
 *
 * Java implementation:
 *
 *     Arrays.sort(nums);
 *
 *     for (int i = 1; i < nums.length; i++) {
 *         if (nums[i] == nums[i - 1]) {
 *             return true;
 *         }
 *     }
 *
 *     return false;
 *
 * Time Complexity: O(n log n)
 * Extra Space: Depends on the sorting implementation.
 *
 * This works, but O(n log n) is slower than the O(n) HashSet approach.
 *
 *
 * ---------------------------------------------------------
 * APPROACH 5: HASHSET - FINAL APPROACH
 * ---------------------------------------------------------
 *
 * The key realization was:
 *
 * We don't need to know HOW MANY TIMES a number appears.
 * We only need to know WHETHER we have already seen it.
 *
 * That makes HashSet the perfect data structure.
 *
 * For every number:
 *
 *     1. Check if it already exists in the Set.
 *     2. If yes -> duplicate found -> return true.
 *     3. Otherwise -> add it to the Set.
 *
 * Example:
 *
 *     nums = [1, 2, 3, 1]
 *
 *     seen = {}
 *
 *     1 -> not present -> add
 *     2 -> not present -> add
 *     3 -> not present -> add
 *     1 -> already present -> return true
 *
 *
 * FINAL SOLUTION:
 */

import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashSet<Integer> seen = new HashSet<>(nums.length);

        for (int num : nums) {

            // add() returns false if the element already exists
            if (!seen.add(num)) {
                return true;
            }
        }

        return false;
    }
}

/*
 * ---------------------------------------------------------
 * COMPLEXITY
 * ---------------------------------------------------------
 *
 * Time Complexity:
 * O(n) average
 *
 * Each element is processed once and HashSet operations
 * (add) take O(1) average time.
 *
 * Space Complexity:
 * O(n)
 *
 * In the worst case, all elements are distinct, so the Set
 * stores all n elements.
 *
 *
 * ---------------------------------------------------------
 * FINAL THOUGHT PROCESS
 * ---------------------------------------------------------
 *
 * My initial goal was to achieve O(n) time with O(1) space,
 * which led me to think about XOR.
 *
 * After checking the properties of XOR against the actual
 * requirements of the problem, I realized XOR cannot reliably
 * detect arbitrary duplicates.
 *
 * Then I considered storing frequencies using a HashMap.
 * That works in O(n), but storing the count is unnecessary.
 *
 * The problem only asks:
 *
 * "Have I seen this number before?"
 *
 * Therefore, HashSet is the most natural and clean solution.
 *
 * Final choice:
 *
 * HashSet
 * O(n) average time
 * O(n) space
 */