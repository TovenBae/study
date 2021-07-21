import unittest

# https://leetcode.com/problems/add-binary/

def climbStairs(n):
    if (n == 1):
        return 1
    
    first = 1
    second = 2
    for i in range(2,n):
        third = first + second
        first = second
        second = third
    
    return second

class Test(unittest.TestCase):
    def test(self):
        n = 2
        output = 2
        self.assertEqual(output, climbStairs(n))

        n = 3
        output = 3
        self.assertEqual(output, climbStairs(n))

        n = 4
        output = 5
        self.assertEqual(output, climbStairs(n))

        n = 5
        output =  8
        self.assertEqual(output, climbStairs(n))

        n = 1
        output = 1
        self.assertEqual(output, climbStairs(n))

        n = 44
        output = 1134903170
        self.assertEqual(output, climbStairs(n))

if __name__ == '__main__':
    unittest.main()
