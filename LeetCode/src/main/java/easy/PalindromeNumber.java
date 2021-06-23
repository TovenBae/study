package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//https://leetcode.com/problems/palindrome-number/
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String sx = "" + x;
        for (int i=0; i<sx.length()/2; ++i) {
            if (sx.charAt(i) != sx.charAt(sx.length()-i-1))
                return false;
        }
        return true;
    }

    public boolean isPalindrome2(int x) {
        boolean rev = false;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
//            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
//            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
//            rev = rev * 10 + pop;
        }
        return rev;
    }

    public boolean isPalindrome3(int x) {
        if(x<0) return false;
        int rev=0;
        int rem;
        int orig=x;
        while(x!=0){
            rem=x%10;
            rev= rev*10 + rem;
            x /=10;
        }
        return orig==rev;
    }

    @Test
    public void test() {
        PalindromeNumber pn = new PalindromeNumber();
        int x = 121;
        boolean Output = true;
        assertEquals(Output, pn.isPalindrome(x));

        x = 12345;
        Output = false;
        assertEquals(Output, pn.isPalindrome(x));

        x = -121;
        Output = false;
        assertEquals(Output, pn.isPalindrome(x));

        x = 10;
        Output = false;
        assertEquals(Output, pn.isPalindrome(x));

        x = -101;
        Output = false;
        assertEquals(Output, pn.isPalindrome(x));

    }

    @Test
    public void test3() {
        PalindromeNumber pn = new PalindromeNumber();
        int x = 121;
        boolean Output = true;
        assertEquals(Output, pn.isPalindrome3(x));

        x = 12345;
        Output = false;
        assertEquals(Output, pn.isPalindrome3(x));


        x = -121;
        Output = false;
        assertEquals(Output, pn.isPalindrome3(x));

        x = 10;
        Output = false;
        assertEquals(Output, pn.isPalindrome3(x));

        x = -101;
        Output = false;
        assertEquals(Output, pn.isPalindrome3(x));

    }
}
