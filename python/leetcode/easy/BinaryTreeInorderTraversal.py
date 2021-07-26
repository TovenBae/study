import unittest
from typing import List
from TreeNode import TreeNode

# https://leetcode.com/problems/binary-tree-inorder-traversal/

class Solution(unittest.TestCase):
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []

        if (root == None): return result

        if (root.left != None) :
            result += Solution.inorderTraversal(self, root.left)

        result += [root.val]

        if (root.right != None) :
            result += Solution.inorderTraversal(self, root.right)

        return result

    def test(self) :
        root = TreeNode(3)
        root = TreeNode(2, root, None)
        root = TreeNode(1, None, root)
        output = [1,3,2]
        result = Solution.inorderTraversal(self, root)
        Solution.checkResult(self, output, result)

        root = TreeNode()
        output = []
        result = Solution.inorderTraversal(self, root)
        Solution.checkResult(self, output, result)

        root = TreeNode(1)
        output = [1]
        result = Solution.inorderTraversal(self, root)
        Solution.checkResult(self, output, result)

        root = TreeNode(1, TreeNode(2), None)
        output = [2,1]
        result = Solution.inorderTraversal(self, root)
        Solution.checkResult(self, output, result)

        root = TreeNode(1, None, TreeNode(2))
        output = [1,2]
        result = Solution.inorderTraversal(self, root)
        Solution.checkResult(self, output, result)

    def checkResult(self, output, result) :
        for i in range(0, len(output)) :
            self.assertEqual(output[i], result[i])

if __name__ == '__main__' :
    unittest.main()