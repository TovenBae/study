package easy;


// https://leetcode.com/problems/sqrtx/

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Given a non-negative integer x, compute and return the square root(제급근) of x.
//        Since the return type is an integer, the decimal digits are truncated,
//        and only the integer part of the result is returned.
//        Note: You are not allowed to use any built-in exponent function or operator,
//        such as pow(x, 0.5) or x ** 0.5.
//
//        Example 1:
//
//        Input: x = 4
//        Output: 2

//        Example 2:
//
//        Input: x = 8
//        Output: 2
//        Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
//
//
//        Constraints:
//        0 <= x <= 2E31 - 1
public class Sqrt {
    // Time Limit Exceeded
    public int mySqrt_1(int x) {
        int i = 1;
        while(i*i < x) {
            i++;
        }
        if (i*i == x) return i;
        else return --i;
    }

    public int mySqrt_2(int x) {
        int i = 1;
        long mok = x / 2;
        while(mok * mok > x) {
            mok = mok / 2;
        }
        if (mok * mok == x) return (int)mok;
        else {
            while(mok*mok < x) {
                mok++;
            }
            if (mok*mok == x) return (int)mok;
            else return (int)--mok;
        }
    }

    public int mySqrt(int x) {
        int i = 1;
        long mok = x / 2;
        while(mok * mok > x) {
            mok = (mok + x/mok) / 2;
        }
        return (int)mok;
    }

    public int mySqrt_ref(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }


    public int mySqrt_ref2(int x) {
        return (int)Math.pow(x, 0.5);
    }

    @Test
    public void test() {
        Sqrt test = new Sqrt();

//        4/2 = 2/2 = 1
//        8/2 = 4/2 = 2/2 = 1
//        9/2 = 4/2 = 2/2 = 1
//        16/2 = 8/2 = 4/2
//        100/2 = 50/2 = 25/2 = 12/2 = 6/2 = 3/2 = 1
//        10000/2 = 5000/2 = 2500/2 = 1250/2 = 625/2 = 312/2 = 156/2 = 78/2

        int x = 4;
        int output = 2;
        assertEquals(output, test.mySqrt(x));

        x = 8;
        output = 2;
        assertEquals(output, test.mySqrt(x));

        x = 10000;
        output = 100;
        assertEquals(output, test.mySqrt(x));

        x = 2147483647;
        output = 46340;
        assertEquals(output, test.mySqrt(x));

    }

}
