package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/

// Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
// Return the linked list sort as well.

//    Example 1 :
//        Input: head = [1,1,2]
//        Output: [1,2]
//
//    Example 2 :
//        Input: head = [1,1,2,3,3]
//        Output: [1,2,3]
//
//    Constraints:
//
//        The number of nodes in the list is in the range [0, 300].
//        -100 <= Node.val <= 100
//        The list is guaranteed to be sorted in ascending order.

import org.junit.Test;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Remove_Duplicates_from_Sorted_List {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode rtn = new ListNode();
        rtn.val = head.val;
        while(head.next != null) {
            head = head.next;
            if (head.val > rtn.val) {
                rtn.next = deleteDuplicates(head);
                break;
            }
        }
        return rtn;
    }

    // Approach 1: Straight-Forward Approach
    public ListNode deleteDuplicates1(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    @Test
    public void test() {
        Remove_Duplicates_from_Sorted_List test = new Remove_Duplicates_from_Sorted_List();
        ListNode head = new ListNode(2);
        head = new ListNode(1, head);
        head = new ListNode(1, head);
        ListNode output = new ListNode(2);
        output = new ListNode(1, output);
        head = test.deleteDuplicates(head);
        checkResult(output, head);

        head = new ListNode(3);
        head = new ListNode(3, head);
        head = new ListNode(2, head);
        head = new ListNode(1, head);
        head = new ListNode(1, head);
        output = new ListNode(3);
        output = new ListNode(2, output);
        output = new ListNode(1, output);
        head = test.deleteDuplicates(head);
        checkResult(output, head);

        head = new ListNode(1);
        head = new ListNode(1, head);
        head = new ListNode(1, head);
        output = new ListNode(1);
        head = test.deleteDuplicates(head);
        checkResult(output, head);

    }

    private void checkResult(ListNode output, ListNode head) {
        int i = 0;
        while(output != null) {
            assertEquals("pos : " + i++, output.val, head.val);
            output = output.next;
            head = head.next;
        }
        assert head == null;
    }
}
