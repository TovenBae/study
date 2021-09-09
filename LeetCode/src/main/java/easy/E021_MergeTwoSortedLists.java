package easy;

import org.junit.Test;

import java.util.Stack;

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
public class E021_MergeTwoSortedLists {
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
            l1.next = mergeTwoLists_sk(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists_sk(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists_sk(ListNode l1, ListNode l2) {

        ListNode bigNext = l1.val >= l2.val ? l1 : l2;
        ListNode smallNext = l1.val >= l2.val ? l2 : l1;

        Stack<Integer> stack = new Stack<>();
        // stack에 작은 순으로 쌓는데
        while (bigNext != null || smallNext != null) {
            // big > small => small 숫자 샇기
            if ((bigNext != null && smallNext != null) && bigNext.val > smallNext.val) {
                stack.push(smallNext.val);
                smallNext = smallNext.next;
            } else if ((bigNext != null && smallNext != null) && bigNext.val <= smallNext.val) {
                // big <= small => big 숫자 샇기
                stack.push(bigNext.val);
                bigNext = bigNext.next;
            } else if (bigNext != null && smallNext == null){
                // big은 남았지만 small은 없는 상태
                stack.push(bigNext.val);
                bigNext = bigNext.next;
            } else if (bigNext == null && smallNext != null) {
                stack.push(smallNext.val);
                smallNext = smallNext.next;
            }
        }

        ListNode nextNode = null;
        ListNode resultNode = null;
        int i = 0;
        // stack으로 nodelist 만들기
        while (stack.size() > 0) {
            int a  = stack.pop();
            if (i == 0) {
                nextNode = new ListNode(a);
            } else {
                resultNode = new ListNode(a, nextNode);
                nextNode = resultNode;
            }
            i++;
        }
        return resultNode;
    }

    public void addListNode(ListNode input, int val) {
        if(input==null) {
            input = new ListNode(val);                //헤드가 비어있다면 헤드로 지정
        }else {
            ListNode node = input;                    //첫 탐색 노드를 헤드로 잡고
            while(node.next != null){                 //헤드의 다음이 있다면
                node = node.next;                       //다음 노드로 포인터 이동
            }
            node.next = new ListNode(val);          //다음 노드가 있고 없고에 따라 포인터가 헤드 혹은 일반 노드로 설정 됨으로 그 다음 노드를 설정
        }
    }
    public ListNode mergeTwoLists_noori(ListNode l1, ListNode l2){
        ListNode node = l1;
        ListNode head = l1;
        while(node.next != null){
            node = node.next;
        }
        node.next=l2;
        while(node.next != null){
            node = node.next;
        }
        node = head;
        try {
            sortingASC(node);

        } catch(Exception e) {
            ;
        }
        return node;
    }

    public void sortingASC(ListNode input) throws InterruptedException {
        ListNode node = input;
        ListNode head = input;
        while(node.next != null){
            if(node.next.val<node.val) {              //현재 가리키는 노드와 다음 노드값을 비교 다음 노드값이 크다면
                ListNode temp = new ListNode(node.val); //임시 노드를 만들어주고
                temp.next = node.next.next;             //포인터 할당
                node.val = node.next.val;               //현재 가리키는 노드값을 다음 노드값으로 변환해주고
                node.next = temp;                       //현재 노드에 포인터 할당
                node = head;                            //다시 처음부터 탐색
            }else {
                node = node.next;                       //정렬 할 일이 없으면 다음 노드로 포인터 이동
            }
        }
        node = head;
        System.out.print(node.val);
        while(node.next != null){
            node = node.next;
            System.out.print("->"+node.val);
        }
    }

    @Test
    public void test() {
        E021_MergeTwoSortedLists test = new E021_MergeTwoSortedLists();
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

        checkEqualsListNode(Output, test.mergeTwoLists_noori(l1, l2));

        ListNode l3 = null; // [];
        ListNode l4 = null; // [];
        ListNode Output2 = null;  // [];
        checkEqualsListNode(Output2, test.mergeTwoLists_noori(l3, l4));

        l1 = new ListNode(); // [];
        l2 = new ListNode(0); // [0];
        Output = new ListNode(); // [0];
        checkEqualsListNode(Output, test.mergeTwoLists_noori(l1, l2));

        l1 = new ListNode(1); // [1];
        l2 = new ListNode(2); // [2];
        Output = new ListNode(1); // [1,2];
        Output.next = new ListNode(2);
        checkEqualsListNode(Output, test.mergeTwoLists_noori(l1, l2));

        l1 = new ListNode(-9); //
        l1.next = new ListNode(3); // [-9,3]
        l2 = new ListNode(5);
        l2.next = new ListNode(7);   // [5,7];
        Output = new ListNode(7);
        Output = new ListNode(5, Output);
        Output = new ListNode(3, Output);
        Output = new ListNode(-9, Output); // [-9, 3,5,7];
        checkEqualsListNode(Output, test.mergeTwoLists_noori(l1, l2));
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
