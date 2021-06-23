package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
    public int reverse(int x) {
        int isMinus = 1;
        if (x < 0) {
            isMinus = -1;
            x = x * -1;
        }
        String x1 = "" + x;
        StringBuffer sb = new StringBuffer();
        for (int i=x1.length()-1; i>=0; i--) {
            sb.append(x1.charAt(i));
        }

        return Integer.parseInt(sb.toString()) * isMinus;
    }

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    @Test
    public void test() {
        int x = 0;
        int output = 0;
        ReverseInteger ri = new ReverseInteger();

        x = 123;
        output = 321;
        assertEquals(output, ri.reverse(x));

        x = -123;
        output = -321;
        assertEquals(output, ri.reverse(x));

        x = 120;
        output =  21;
        assertEquals(output, ri.reverse(x));

        x = 0;
        output = 0;
        assertEquals(output, ri.reverse(x));

//        x = 1534236469;
//        output = 9646324351;
//        assertEquals(output, ri.reverse(x));
    }

    @Test
    public void test2() {
        int x = 0;
        int output = 0;
        ReverseInteger ri = new ReverseInteger();

        x = 123;
        output = 321;
        assertEquals(output, ri.reverse2(x));

        x = -123;
        output = -321;
        assertEquals(output, ri.reverse2(x));

        x = 120;
        output =  21;
        assertEquals(output, ri.reverse2(x));

        x = 0;
        output = 0;
        assertEquals(output, ri.reverse2(x));
    }

}
