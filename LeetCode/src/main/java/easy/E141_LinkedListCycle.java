package easy;

/**
 https://leetcode.com/problems/linked-list-cycle/

 Given head, the head of a linked list, determine if the linked list has a cycle in it.
 There is a cycle in a linked list if there is some node in the list that can be reached
 again by continuously following the next pointer.
 Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 Note that pos is not passed as a parameter.

        Return true if there is a cycle in the linked list. Otherwise, return false.

    Example 1:
        Input: head = [3,2,0,-4], pos = 1
        Output: true
        Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
    Example 2:
        Input: head = [1,2], pos = 0
        Output: true
        Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
    Example 3:
        Input: head = [1], pos = -1
        Output: false
        Explanation: There is no cycle in the linked list.

    Constraints:
        The number of the nodes in the list is in the range [0, 10E4].
        -10E5 <= Node.val <= 10E5
        pos is -1 or a valid index in the linked-list.

        Follow up: Can you solve it using O(1) (i.e. constant) memory?

 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class E141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        Map<ListNode, Boolean> map = new HashMap<>();
        while(head.next != null) {
            if (map.get(head) != null && map.get(head))
                return true;
            else
                map.put(head, true);
            head = head.next;
        }
        return false;
    }

    // Solution 1 : 거북이와 토끼 알고리즘(Tortoise and Hare Algorithm)
    //  - ref : https://fierycoding.tistory.com/45
    public boolean hasCycle_tortoise_hare(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode tortoise = head;
        ListNode hare = head;

        while(tortoise.next != hare.next.next) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (hare == null)
                return false;
        }

        return true;
    }

    @Test
    public void test() {
        ListNode head;
        E141_LinkedListCycle test  = new E141_LinkedListCycle();

        // Input: head = [3,2,0,-4], pos = 1
        head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;

        assertThat(test.hasCycle_tortoise_hare(head), equalTo(true));

        // Input: head = [1,2], pos = 0
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        assertThat(test.hasCycle_tortoise_hare(head), equalTo(true));

        // Input: head = [1], pos = -1
        head = new ListNode(1);
        assertThat(test.hasCycle_tortoise_hare(head), equalTo(false));
    }
}
