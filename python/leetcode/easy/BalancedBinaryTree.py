import unittest;
from TreeNode import TreeNode
from hamcrest import * 

class Solution(unittest.TestCase) :
    def isBalanced(self, root:TreeNode) -> bool :
        if (not root) : return True

        stack = []
        map = {}
        stack.append(root)
        while(stack) :
            root = stack.pop()
            if (((not root.left) or (root.left and map.get(root.left, 0))) and
                ((not root.right) or (root.right and map.get(root.right, 0)))) : 
                left = 0
                if (map.get(root.left, 0)) :
                    left = map.get(root.left, 0)
                right = 0
                if (map.get(root.right, 0)) :
                    right = map.get(root.right, 0)
                if (abs(left-right) > 1) :
                    return False
                map[root] = max(left, right) + 1
            else :
                if (root.left and not map.get(root.left, 0)) :
                    stack.append(root)
                    stack.append(root.left)
                else :
                    stack.append(root)
                    stack.append(root.right)
        return True

    # Solution 1 : Reculsive
    def isBalanced2(self, root):
                
        def check(root):
            if root is None:
                return 0
            left  = check(root.left)
            right = check(root.right)
            if left == -1 or right == -1 or abs(left - right) > 1:
                return -1
            return 1 + max(left, right)
                
        return check(root) != -1
    
    # Solution 2 : Iterative, based on postorder traversal:
    def isBalanced3(self, root):
        stack, node, last, depths = [], root, None, {}
        while stack or node:
            if node:
                stack.append(node)
                node = node.left
            else:
                node = stack[-1]
                if not node.right or last == node.right:
                    node = stack.pop()
                    left, right  = depths.get(node.left, 0), depths.get(node.right, 0)
                    if abs(left - right) > 1: return False
                    depths[node] = 1 + max(left, right)
                    last = node
                    node = None
                else:
                    node = node.right
        return True


    def test(self) :
        root = TreeNode(3, 
                        TreeNode(9), 
                        TreeNode(20, TreeNode(4), TreeNode(4)))
        assert_that(self.isBalanced(root), equal_to(True))

        root = TreeNode(1,
                    TreeNode(2,
                        TreeNode(3, TreeNode(4), TreeNode(4)),
                    TreeNode(2)))

        assert_that(self.isBalanced(root), equal_to(False))

        root = None
        assert_that(self.isBalanced(root), equal_to(True))

        root = TreeNode(1,
                        TreeNode(2,
                                TreeNode(3, TreeNode(4), None),
                                None),
                        TreeNode(2,
                                None,
                                TreeNode(3, None, TreeNode(4)))
                        )
        assert_that(self.isBalanced(root), equal_to(False))

if __name__ == '__main__' :
    unittest.main()
