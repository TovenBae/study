package easy;

import org.junit.Test;

import static org.junit.Assert.*;

// https://leetcode.com/problems/add-binary/

//Given two binary strings a and b, return their sum as a binary string.
//
//        Example 1:
//
//        Input: a = "11", b = "1"
//        Output: "100"

//        Example 2:
//
//        Input: a = "1010", b = "1011"
//        Output: "10101"
//
//
//        Constraints:
//
//        1 <= a.length, b.length <= 10E4
//        a and b consist only of '0' or '1' characters.
//        Each string does not contain leading zeros except for the zero itself.
public class E067_AddBinary {
    public String addBinary2(String a, String b) {
        String rtn = "";

        // -- Runtime Overflow exception 발생함.
        int sum = Integer.parseInt(a) + Integer.parseInt(b);
        if (sum == 0) return "0";

        int rem = 0;
        while(sum != 0) {
            rem = rem + sum % 10;

            rtn = rem % 2 + rtn;

            rem = rem / 2;
            sum = sum / 10;
        }
        if (rem == 1)
            return "1" + rtn;
        else
            return "" + rtn;
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        E067_AddBinary test = new E067_AddBinary();

        String a = "11";
        String b = "1";
        String output = "100";
        assertEquals(output, test.addBinary(a,b));

        a = "1010";
        b = "1011";
        output = "10101";
        assertEquals(output, test.addBinary(a,b));

        a = "1110";
        b = "1011";
        output = "11001";
        assertEquals(output, test.addBinary(a,b));

        a = "0";
        b = "0";
        output = "0";
        assertEquals(output, test.addBinary(a,b));

        a = "1110110101";
        b = "1110111011";
        output = "11101110000";
        assertEquals(output, test.addBinary(a,b));

    }
}
