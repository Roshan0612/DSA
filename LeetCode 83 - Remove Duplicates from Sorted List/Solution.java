/**
 * LeetCode 83 - Remove Duplicates from Sorted List
 *
 * Initial Approach:
 * - First handle the basic cases:
 * 1. If the list is empty, return null.
 * 2. If there is only one node, return the head.
 *
 * - Since the linked list is sorted, duplicate values will always
 * appear next to each other.
 *
 * - Traverse the list while keeping track of the current node.
 * - Compare the current node with the next node.
 * - If both values are the same, skip the duplicate node by
 * connecting the current node directly to the next node's next.
 * - If the values are different, move to the next node.
 *
 * This modifies the existing linked list instead of creating
 * a new linked list.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

class Solution {
    public ListNode deleteDuplicates(ListNode head) {

        // Basic case: empty list or only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Start traversing from the first node
        ListNode current = head;

        while (current != null && current.next != null) {

            // Duplicate found
            if (current.val == current.next.val) {

                // Skip the duplicate node
                current.next = current.next.next;

            } else {

                // No duplicate, move to the next node
                current = current.next;
            }
        }

        return head;
    }
}