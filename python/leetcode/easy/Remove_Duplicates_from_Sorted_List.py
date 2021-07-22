import unittest
from ListNode import ListNode

# https://leetcode.com/problems/add-binary/

class Solution(unittest.TestCase):
    def deleteDuplicates(head):
        if (head == None): return None
        rtn = ListNode(head.val)
        while(head.next != None):
            head = head.next
            if (head.val > rtn.val):
                rtn.next = Solution.deleteDuplicates(head)
                break
        return rtn

    def test(self):
        head = ListNode(2)
        head = ListNode(1, head)
        head = ListNode(1, head)
        output = ListNode(2)
        output = ListNode(1, output)
        head = Solution.deleteDuplicates(head)

    def checkResult(self, output, head):
        i = 0
        while (output != None):
            self.assertEqual(output.val, head.val)
            output = output.next
            head = head.next
        self.assertFalse(head)

if __name__ == '__main__':
    unittest.main()