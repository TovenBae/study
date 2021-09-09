package easy;

// https://leetcode.com/problems/valid-palindrome/

// Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//    Example 1:
//
//        Input: s = "A man, a plan, a canal: Panama"
//        Output: true
//        Explanation: "amanaplanacanalpanama" is a palindrome.
//
//    Example 2:
//
//        Input: s = "race a car"
//        Output: false
//        Explanation: "raceacar" is not a palindrome.
//
//
//    Constraints:
//
//        1 <= s.length <= 2 * 105
//        s consists only of printable ASCII characters.

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class E125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) return false;

        s = s.toLowerCase();
        int j = s.length()-1;
        for(int i=0; i<j; i++) {
            if (!isAlphaNumeric(s.charAt(i))) {
                continue;
            }
            while(!isAlphaNumeric(s.charAt(j))) {
                j--;
            }
            if (s.charAt(i) != s.charAt(j))
                return false;
            else
                j--;
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        if ((c >= 'a' && c <='z') || (c >= '0' && c <= '9')) {
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        E125_ValidPalindrome test = new E125_ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        assertThat(test.isPalindrome(s), equalTo(true));

        s = "race a car";
        assertThat(test.isPalindrome(s), equalTo(false));

        s = "0P";
        assertThat(test.isPalindrome(s), equalTo(false));

        s = ",P";
        assertThat(test.isPalindrome(s), equalTo(true));

        s = ",,,,,P";
        assertThat(test.isPalindrome(s), equalTo(true));

        s = "P,,,,,P";
        assertThat(test.isPalindrome(s), equalTo(true));

        s = " ";
        assertThat(test.isPalindrome(s), equalTo(true));

        s = ",,,,";
        assertThat(test.isPalindrome(s), equalTo(true));

        s = "a";
        assertThat(test.isPalindrome(s), equalTo(true));

    }
}
