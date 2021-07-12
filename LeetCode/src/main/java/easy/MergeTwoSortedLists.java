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
//    Constraints:
//    The number of nodes in both lists is in the range [0, 50].
//    -100 <= Node.val <= 100
//    Both l1 and l2 are sorted in non-decreasing order
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode rtn = new ListNode();
        ListNode lastNode = new ListNode();

        boolean isFirst = true;
        while(l1 != null || l2 != null) {
            if (l2.val <= l1.val) {
                ListNode tmp = new ListNode(l2.val);
                if (isFirst) {
                    rtn = tmp;
                    isFirst = false;
                } else {
                    lastNode.next = tmp;
                }
                lastNode = tmp;
                l2 = l2.next;

                if (l2 == null) {
                    lastNode.next = l1;
                    break;
                }
            } else {
                ListNode tmp = new ListNode(l1.val);
                if (isFirst) {
                    rtn = tmp;
                    isFirst = false;
                } else {
                    lastNode.next = tmp;
                }
                lastNode = tmp;

                l1 = l1.next;
                if (l1 == null) {
                    lastNode.next = l2;
                    break;
                }
            }
        }

        return rtn;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode res = l1; //resulr list;
        ListNode ins = l2; //inserted list
        ListNode prev = null; // previous node
        l1 = null; //set head to null
        while(res != null && ins != null) {
            if(ins.val <= res.val){
                l2 = ins.next; //keep new head of inserted list
                if(l1 != null) prev.next = ins;
                prev = ins;
                ins.next = res;
                ins = l2; //set new head of inserted list
            }
            else {
                prev = res;
                res = res.next; //change result to next node
            }
            if(l1 == null) l1 = prev;
        }
        if(ins != null) {
            prev.next = ins; //merge tail of inserted list
        }
        return l1;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) { return l2; }
        if (l2 == null) { return l1; }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    @Test
    public void test() {
        MergeTwoSortedLists test = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(4);
        l1 = new ListNode(2, l1);
        l1 = new ListNode(1, l1); // [1,2,4];

        ListNode l2 = new ListNode(4);
        l2 = new ListNode(3, l2);
        l2 = new ListNode(1, l2); // [1,3,4]

        ListNode Output = new ListNode(4);
        Output = new ListNode(4, Output);
        Output = new ListNode(3, Output);
        Output = new ListNode(2, Output);
        Output = new ListNode(1, Output);
        Output = new ListNode(1, Output); // : [1,1,2,3,4,4];

        checkEqualsListNode(Output, test.mergeTwoLists(l1, l2));

        ListNode l3 = null; // [];
        ListNode l4 = null; // [];
        ListNode Output2 = null;  // [];
        checkEqualsListNode(Output2, test.mergeTwoLists(l3, l4));

        l1 = new ListNode(); // [];
        l2 = new ListNode(0); // [0];
        Output = new ListNode(); // [0];
        checkEqualsListNode(Output, test.mergeTwoLists(l1, l2));

        l1 = new ListNode(1); // [1];
        l2 = new ListNode(2); // [2];
        Output = new ListNode(1); // [1,2];
        Output.next = new ListNode(2);
        checkEqualsListNode(Output, test.mergeTwoLists(l1, l2));

        l1 = new ListNode(-9); //
        l1.next = new ListNode(3); // [-9,3]
        l2 = new ListNode(5);
        l2.next = new ListNode(7);   // [5,7];
        Output = new ListNode(7);
        Output = new ListNode(5, Output);
        Output = new ListNode(3, Output);
        Output = new ListNode(-9, Output); // [-9, 3,5,7];
        checkEqualsListNode(Output, test.mergeTwoLists(l1, l2));
    }

    private void checkEqualsListNode(ListNode a, ListNode o) {
        int i = 0;
        while(a != null) {
            assertEquals("pos : " + i++, a.val, o.val);
            a = a.next;
            o = o.next;
        }
    }
}
