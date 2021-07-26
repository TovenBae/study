import unittest
from TreeNode import TreeNode

class Solution(unittest.TestCase):
    def isSameTree(self, p:TreeNode, q:TreeNode) -> bool :
        if (p == None and q == None) :
            return True
        elif (p == None or q == None) :
            return False

        if (p.val != q.val) :
            return False
        
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)

    # Approach 1: Recursion
    def isSameTree2(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """    
        # p and q are both None
        if not p and not q:
            return True
        # one of p and q is None
        if not q or not p:
            return False
        if p.val != q.val:
            return False
        return self.isSameTree(p.right, q.right) and \
               self.isSameTree(p.left, q.left)

    # Approach 2: Iteration
    def isSameTree3(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """    
        def check(p, q):
            # if both are None
            if not p and not q:
                return True
            # one of p and q is None
            if not q or not p:
                return False
            if p.val != q.val:
                return False
            return True
        
        deq = deque([(p, q),])
        while deq:
            p, q = deq.popleft()
            if not check(p, q):
                return False
            
            if p:
                deq.append((p.left, q.left))
                deq.append((p.right, q.right))
                    
        return True

    def test(self) :
        p = TreeNode(1, TreeNode(2), TreeNode(3))
        q = TreeNode(1, TreeNode(2), TreeNode(3))
        output = True
        result = Solution.isSameTree(self, p,q)
        self.assertEqual(output, result)

        p = TreeNode(1, TreeNode(2), None)
        q = TreeNode(1, None, TreeNode(2))
        output = False
        result = Solution.isSameTree(self, p,q)
        self.assertEqual(output, result)

        p = TreeNode(1, TreeNode(2), TreeNode(1))
        q = TreeNode(1, TreeNode(1), TreeNode(2))
        output = False
        result = Solution.isSameTree(self, p,q)
        self.assertEqual(output, result)

        p = TreeNode(10, TreeNode(5), TreeNode(15))
        q = TreeNode(5, None, TreeNode(15))
        q = TreeNode(10, q, None)
        output = False
        result = Solution.isSameTree(self, p,q)
        self.assertEqual(output, result)

        p = TreeNode(1, TreeNode(2), TreeNode(3))
        q = TreeNode(1, TreeNode(2), TreeNode(3))
        output = True
        result = Solution.isSameTree(self, p,q)
        self.assertEqual(output, result)


if __name__ == '__main__':
    unittest.main()