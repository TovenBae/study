package easy;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/length-of-last-word/

//Given a string s consists of some words separated by spaces,
// return the length of the last word in the string. If the last word does not exist, return 0.
//        A word is a maximal substring consisting of non-space characters only.
//
//        Example 1:
//        Input: s = "Hello World"
//        Output: 5

//        Example 2:
//        Input: s = " "
//        Output: 0
//
//
//        Constraints:
//        1 <= s.length <= 10E4
//        s consists of only English letters and spaces ' '.


import org.junit.Test;

public class LengthofLastWord {
    public int lengthOfLastWord2(String s) {
        String [] ss = s.split(" ");

        if (ss.length == 0) return 0;
        return ss[ss.length-1].length();
    }

    public int lengthOfLastWord(String s) {
        boolean isChar = false;
        int rtn = 0;
        for(int i=s.length(); i>0; i--) {
            char c = s.charAt(i-1);
            if (c == ' ') {
                if (isChar)
                    return rtn;
                else
                    continue;
            }
            rtn++;
            isChar = true;


        }
        return rtn;
    }
    @Test
    public void test() {
        LengthofLastWord test = new LengthofLastWord();
        String s = "Hello World";
        int output = 5;
        assertEquals(output, test.lengthOfLastWord(s));

        s = " ";
        output = 0;
        assertEquals(output, test.lengthOfLastWord(s));

        s = "Hello ";
        output = 5;
        assertEquals(output, test.lengthOfLastWord(s));

        s = " Hello";
        output = 5;
        assertEquals(output, test.lengthOfLastWord(s));

        s = " Hello  ";
        output = 5;
        assertEquals(output, test.lengthOfLastWord(s));
    }

}
