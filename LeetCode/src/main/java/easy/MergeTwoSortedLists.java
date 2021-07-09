package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

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

// https://leetcode.com/problems/merge-two-sorted-lists/

// Merge two sorted linked lists and return it as a sorted list.
// The list should be made by splicing together the nodes of the first two lists.

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rtn = new ListNode();

        return rtn;
    }

    @Test
    public void test() {
        MergeTwoSortedLists test = new MergeTwoSortedLists();
        String s = "()";
        ListNode l1 = new ListNode(); // [1,2,4];
        ListNode l2 = new ListNode(); // [1,3,4]
        ListNode Output = new ListNode(); // : [1,1,2,3,4,4];
        assertEquals(Output, test.mergeTwoLists(l1, l2));

//        l1 = l1 = [], l2 = [];
//        Output = [];
        assertEquals(Output, test.mergeTwoLists(l1, l2));

//        l1 = l1 = [], l2 = [0]
//        Output = [0];
        assertEquals(Output, test.mergeTwoLists(l1, l2));

    }
}
