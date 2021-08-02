import unittest
from TreeNode import TreeNode
from hamcrest import * 

class Solution(unittest.TestCase) :
    def sortedArrayToBST(self, nums) -> TreeNode :
        if (not nums) :
            return None
        head : TreeNode = self.helper(nums, 0, len(nums)-1);
        return head
    
    def helper(self, nums, low, high) -> TreeNode :
        if (low > high) :
            return None
        if (high - low == 0) :
            return TreeNode(nums[low])
        if (high - low == 1) :
            return TreeNode(nums[high], TreeNode(nums[low]), None)
        if (high - low == 2) :
            return TreeNode(nums[low+1], TreeNode(nums[low]), TreeNode(nums[high]))

        mid = int((low + high) / 2)
        node = TreeNode(nums[mid])
        node.left = self.helper(nums, low, mid-1)
        node.right = self.helper(nums, mid+1, high)
        return node
        
    def test(self) :
        nums = [-10,-3,0,5,9]
        output = TreeNode(0)
        sub = TreeNode(-3, TreeNode(-10), None)     # case : add left 
        # sub = TreeNode(-10, None, TreeNode(-3))   # case : add right 
        output.left = sub
        sub = TreeNode(9, TreeNode(5), None)     # case : add left 
        # sub = TreeNode(5, None, TreeNode(9))   # case : add right 
        output.right = sub
        result = self.sortedArrayToBST(nums)
        assert_that(self.isSameTree(result, output), equal_to(True))

        nums = [1, 3]
        output = TreeNode(3, TreeNode(1), None)     # case : add left 
        # output = TreeNode(1, None, TreeNode(3))     # case : add right
        result = self.sortedArrayToBST(nums)
        assert_that(self.isSameTree(result, output), equal_to(True))

    def isSameTree(self, p:TreeNode, q:TreeNode) -> bool :
        if (not p and not q) :
            return True
        elif (not p or not q) :
            return False
        elif (p.val != q.val) :
            return False
        return self.isSameTree(p.right, q.right) and self.isSameTree(p.left, q.left)

if __name__ == '__main__' :
    unittest.main()
