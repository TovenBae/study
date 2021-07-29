import unittest
from TreeNode import TreeNode
from hamcrest import * 


class Solution(unittest.TestCase) : 
    def maxDepth(self, root:TreeNode) -> int :
        if (not root) :
            return 0

        depth = 0
        maxDepth = 0
        stack = []
        level = []
        while(root or stack) :
            while(root) :
                depth += 1
                stack.append(root)
                level.append(depth)
                root = root.left
                if (depth > maxDepth) :
                    maxDepth = depth
            root = stack.pop()
            depth = level.pop()
            root = root.right
        return maxDepth

    def test(self) :
        root = TreeNode(3)
        sub = TreeNode(9)
        root.left = sub
        sub = TreeNode(20, TreeNode(15), TreeNode(7))
        root.right = sub
        assert_that(self.maxDepth(root), equal_to(3))

        root = TreeNode(1, None, TreeNode(2))
        assert_that(self.maxDepth(root), equal_to(2))

        root = None
        assert_that(self.maxDepth(root), equal_to(0))

        root = TreeNode()
        assert_that(self.maxDepth(root), equal_to(1))

        root = TreeNode(1)
        sub = TreeNode(2, TreeNode(4), TreeNode(5))
        root.left = sub
        sub = TreeNode(3)
        root.right = sub
        assert_that(self.maxDepth(root), equal_to(3))

        sub = TreeNode(6)
        sub = TreeNode(5, None, sub)
        sub = TreeNode(4, None, sub)
        sub = TreeNode(3, None, sub)
        root = TreeNode(2)
        root.right = sub
        assert_that(self.maxDepth(root), equal_to(5))

        root = TreeNode(0, TreeNode(2), TreeNode(4))
        sub = root.left
        sub.left = TreeNode(1, TreeNode(5), TreeNode(7))
        sub = root.right
        sub.left = TreeNode(3, None, TreeNode(6))
        sub.right = TreeNode(-1, None, TreeNode(8))
        assert_that(self.maxDepth(root), 4)

if __name__ == '__main__' :
    unittest.main()
