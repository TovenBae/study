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

import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.equals("")) return false;

        s = s.toLowerCase(Locale.ROOT);
        int j = 0;
        for(int i=0; i<s.length()/2; i++) {
            if (s.charAt(i) < 'a' || s.charAt(i) > 'z') {
                j++;
                continue;
            }
        }
        return true;
    }

    @Test
    public void test() {
        ValidPalindrome test = new ValidPalindrome();
        String s = "A man, a plan, a canal: Panama";
        assertThat(test.isPalindrome(s), equalTo(true));

        s = "race a car";
        assertThat(test.isPalindrome(s), equalTo(false));
    }
}
