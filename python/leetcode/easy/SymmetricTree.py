from hamcrest import * 
# ModuleNotFoundError: No module named 'hamcrest' -> $ conda install PyHamcrest
import unittest

from TreeNode import TreeNode

class Solution(unittest.TestCase) : 
    def isSymmetric(self, root:TreeNode) -> bool :
        n1 = root.left
        n2 = root.right
        st1 = []
        st2 = []
        while(n1 or n2 or st1 or st2) :
            while(n1 or n2) :
                if (n1 == None and n2 == None) : 
                    continue
                elif (n1 == None or n2 == None) :
                    return False
                elif (n1.val != n2.val) :
                    return False

                st1.append(n1)
                st2.append(n2)
                n1 = n1.left
                n2 = n2.right
            
            n1 = st1.pop()
            n2 = st2.pop()
            n1 = n1.right
            n2 = n2.left
        
        return True

    def test(self) :
        root = TreeNode(1)
        sub = TreeNode(2, TreeNode(3), TreeNode(4))
        root.left = sub
        sub = TreeNode(2, TreeNode(4), TreeNode(3))
        root.right = sub
        isTrue = Solution.isSymmetric(self, root)
        self.assertEqual(True, isTrue)
        assert_that(isTrue, equal_to(True))

        root = TreeNode(1)
        sub = TreeNode(2, None, TreeNode(3))
        root.left = sub
        sub = TreeNode(2, None, TreeNode(3))
        root.right = sub
        isTrue = Solution.isSymmetric(self, root)
        self.assertEqual(False, isTrue)
        # assert_that(isTrue, equal_to(False))

        root = TreeNode(1)
        sub = TreeNode(2, TreeNode(3), TreeNode(4))
        root.left = sub
        sub = TreeNode(2, TreeNode(3), TreeNode(4))
        root.right = sub
        isTrue = Solution.isSymmetric(self, root)
        self.assertEqual(False, isTrue)

        root = TreeNode(1)
        sub = TreeNode(2, None, TreeNode(4))
        root.left = sub
        sub = TreeNode(2, TreeNode(4), TreeNode(3))
        root.right = sub
        isTrue = Solution.isSymmetric(self, root)
        self.assertEqual(False, isTrue)

        root = TreeNode(1)
        sub = TreeNode(2, TreeNode(3), TreeNode(4))
        root.left = sub
        sub = TreeNode(2, TreeNode(4), TreeNode(3))
        root.right = sub
        isTrue = Solution.isSymmetric(self, root)
        self.assertEqual(True, isTrue)

        root = TreeNode(1)
        sub = TreeNode(1)
        root.left = sub
        isTrue = Solution.isSymmetric(self, root)
        self.assertEqual(False, isTrue)

        root = TreeNode(2)
        sub = TreeNode(3, TreeNode(4), TreeNode(5))
        root.left = sub
        sub = TreeNode(3, None, TreeNode(4))
        root.right = sub
        isTrue = Solution.isSymmetric(self, root)
        self.assertEqual(False, isTrue)


if __name__ == '__main__' :
    unittest.main()

