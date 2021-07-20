import unittest

# https://leetcode.com/problems/add-binary/

# class TestStringMethods(unittest.TestCase):
#     def test_upper(self):
#         self.assertEqual('foo'.upper(), 'FOO')
    
#     def test_isupper(self):
#         self.assertTrue('FOO'.isupper())
#         self.assertFalse('Foo'.isupper())

#     def test_split(self):
#         s = 'hello world'
#         self.assertEqual(s.split(), ['hello', 'world'])
#         with self.assertRaises(TypeError):
#             s.split(2)


def addBinary(a, b):
    sb = ''
    i = len(a) -1
    j = len(b) -1
    carry = 0
    while(i >=0 or j >= 0):
        sum = carry
        if (j >= 0): 
            sum += int(b[j])
            j -= 1 
        if (i >= 0): 
            sum += int(a[i])
            i -= 1
        sb += str(sum % 2)
        carry = int(sum / 2)
    
    if (carry>0): sb += str(carry)

    # reverse string
    return sb[::-1]

class MyTest(unittest.TestCase):
    def test(self):
        a = '11'
        b = '1'
        output = '100'
        self.assertEqual(output, addBinary(a, b))

        a = '1010'
        b = '1011'
        output = '10101'
        self.assertEqual(output, addBinary(a, b))

        a = '1110'
        b = '1011'
        output = '11001'
        self.assertEqual(output, addBinary(a, b))

        a = '0'
        b = '0'
        output = '0'
        self.assertEqual(output, addBinary(a, b))

        a = '1110110101'
        b = '1110111011'
        output = '11101110000'
        self.assertEqual(output, addBinary(a, b))

if __name__ == '__main__':
    unittest.main()
