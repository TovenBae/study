import unittest

# https://leetcode.com/problems/merge-sorted-array/

class Solution(unittest.TestCase):
    def merge(self, nums1, m, nums2, n):
        if (n == 0):
            return

        i = m-1
        j = n-1
        k = m+n-1
        while(i>=0 and j>=0):
            if (nums1[i] > nums2[j]):
                nums1[k] = nums1[i]
                i -= 1
            else:
                nums1[k] = nums2[j]
                j -= 1
            k -= 1
        while(j>=0):
            nums1[j] = nums2[j]
            j -= 1
            

    def test(self):
        nums1 = [1,2,3,0,0,0]
        m = 3
        nums2 = [2,5,6]
        n = 3
        output = [1,2,2,3,5,6]
        Solution.merge(self, nums1, m, nums2, n)
        Solution.checkResult(self, output, nums1)

        nums1 = [1]
        m = 1
        nums2 = []
        n = 0
        output = [1]
        Solution.merge(self, nums1, m, nums2, n)
        Solution.checkResult(self, output, nums1)

        nums1 = [0]
        m = 0
        nums2 = [1]
        n = 1
        output = [1]
        Solution.merge(self, nums1, m, nums2, n)
        Solution.checkResult(self, output, nums1)

        nums1 = [0,0,3,0,0,0,0,0,0]
        m = 3
        nums2 = [-1,1,1,1,2,3]
        n = 6
        output = [-1,0,0,1,1,1,2,3,3]
        Solution.merge(self, nums1, m, nums2, n)
        Solution.checkResult(self, output, nums1)

    def checkResult(self, output, nums1):
        for i in range(0, len(output)):
            self.assertEqual(output[i], nums1[i])

if __name__ == '__main__':
    unittest.main()