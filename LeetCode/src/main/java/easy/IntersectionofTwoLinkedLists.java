package easy;

/**
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 *
 * Given the heads of two singly linked-lists headA and headB,
 * return the node at which the two lists intersect.
 *
 * If the two linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 *
 *
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 *
 * Note that the linked lists must retain their original structure after the function returns.
 *
 * Custom Judge:
 *
 * The inputs to the judge are given as follows (your program is not given these inputs):
 *
 * intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
 * listA - The first linked list.
 * listB - The second linked list.
 * skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
 * skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
 * The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program.
 * If you correctly return the intersected node, then your solution will be accepted.
 *
 * Example 1:
 *      Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 *      Output: Intersected at '8'
 *      Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 *      From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
 *      There are 2 nodes before the intersected node in A;
 *      There are 3 nodes before the intersected node in B.
 *
 * Example 2:
 *      Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 *      Output: Intersected at '2'
 *      Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 *      From the head of A, it reads as [1,9,1,2,4].
 *      From the head of B, it reads as [3,2,4].
 *      There are 3 nodes before the intersected node in A;
 *      There are 1 node before the intersected node in B.
 * Example 3:
 *      Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 *      Output: No intersection
 *      Explanation: From the head of A, it reads as [2,6,4].
 *      From the head of B, it reads as [1,5].
 *      Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 *      Explanation: The two lists do not intersect, so return null.
 *
 * Constraints:
 *      The number of nodes of listA is in the m.
 *      The number of nodes of listB is in the n.
 *      0 <= m, n <= 3 * 10E4
 *      1 <= Node.val <= 10E5
 *      0 <= skipA <= m
 *      0 <= skipB <= n
 * intersectVal is 0 if listA and listB do not intersect.
 * intersectVal == listA[skipA] == listB[skipB] if listA and listB intersect.
 *
 * Follow up: Could you write a solution that runs in O(n) time and use only O(1) memory?
 */

import org.junit.Test;

import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        Stack<ListNode> stackA = new Stack<>(), stackB = new Stack<>();
        ListNode result = null;
        while(headA != null || headB != null) {
            if (headA != null) {
                stackA.push(headA);
                headA = headA.next;
            }
            if (headB != null) {
                stackB.push(headB);
                headB = headB.next;
            }
        }
        while(!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.pop())
                result = stackA.pop();
            else
                return result;
        }
        return result;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }

    @Test
    public void test() {
        ListNode listA, listB, result;

        IntersectionofTwoLinkedLists test = new IntersectionofTwoLinkedLists();

        // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5],
        result = new ListNode(8, new ListNode(4, new ListNode(5)));

        listA = new ListNode(4, new ListNode(1, result));
        listB = new ListNode(5, new ListNode(6, new ListNode(1, result)));

        assertThat(test.getIntersectionNode(listA, listB), equalTo(result));

        // listA = [1,9,1,2,4], listB = [3,2,4],
        result = new ListNode(2, new ListNode(4));
        listA = new ListNode(1, new ListNode(9, result));
        listB = new ListNode(3, result);

        assertThat(test.getIntersectionNode(listA, listB), equalTo(result));

        // listA = [2,6,4], listB = [1,5]
        result = null;
        listA = new ListNode(2, new ListNode(6, new ListNode(4)));
        listB = new ListNode(1, new ListNode(5));

        assertThat(test.getIntersectionNode(listA, listB), equalTo(result));

        // listA = [1], listB = [1], intersect : 1
        result = new ListNode(1);
        listA = result;
        listB = result;

        assertThat(test.getIntersectionNode(listA, listB), equalTo(result));


    }
}
