package easy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/plus-one/

//Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
//        The digits are stored such that the most significant digit is at the head of the list,
//        and each element in the array contains a single digit.
//        You may assume the integer does not contain any leading zero, except the number 0 itself.
//
//        Example 1:
//
//        Input: digits = [1,2,3]
//        Output: [1,2,4]
//        Explanation: The array represents the integer 123.


//        Example 2:
//
//        Input: digits = [4,3,2,1]
//        Output: [4,3,2,2]
//        Explanation: The array represents the integer 4321.


//        Example 3:
//
//        Input: digits = [0]
//        Output: [1]
//
//
//        Constraints:
//
//        1 <= digits.length <= 100
//        0 <= digits[i] <= 9

public class E066_PlusOne {
    public int[] plusOne1(int[] digits) {
        int i = digits.length - 1;
        digits[i] ++;
        while(digits[i] == 10) {
            digits[i] = 0;
            i--;
            if (i < 0) {
               int [] new_digits = new int [digits.length+1];
               new_digits[0] = 1;
               for (i=1; i<new_digits.length;i++) {
                   new_digits[i] = digits[i-1];
               }
               return new_digits;
            } else {
                digits[i]++;
            }
        }
        return digits;
    }

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        digits[i] ++;
        while(digits[i] == 10) {
            digits[i] = 0;
            i--;
            if (i < 0) {
                int [] new_digits = new int [digits.length+1];
                new_digits[0] = 1;
                return new_digits;
            } else {
                digits[i]++;
            }
        }
        return digits;
    }

    public int[] plusOne2(int[] digits) {

        final int len = digits.length;

        for(int index = len - 1; index >= 0; --index){
            if(digits[index] != 9){
                digits[index] += 1;  // if element is not equal to 9, then increment it by 1 and return it
                return digits;
            }
            digits[index] = 0; // else if element is 9, then make that element as 0(zero)
        }

        final int[] result = new int[len + 1]; //  for cases where all elements are 9, then we have to create a new array of 1 larger length than the original array
        result[0] = 1; // making the 1st element as 1 and rest will be 0 as the default value of int is 0, so all elements will be 0 except for 1st element which will be 1
        return result;
    }

    @Test
    public void test() {
        E066_PlusOne test = new E066_PlusOne();

        int [] digits = {1,2,3};
        int [] output = {1,2,4};
        assertArrayEquals(output, test.plusOne(digits));

        digits = new int[] {4,3,2,1};
        output = new int[] {4,3,2,2};
        assertArrayEquals(output, test.plusOne(digits));

        digits = new int[] {0};
        output = new int[] {1};
        assertArrayEquals(output, test.plusOne(digits));

        digits = new int[] {9};
        output = new int[] {1, 0};
        assertArrayEquals(output, test.plusOne(digits));

        digits = new int[] {9,9};
        output = new int[] {1,0,0};
        assertArrayEquals(output, test.plusOne(digits));
    }
}
