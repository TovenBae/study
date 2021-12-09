package easy;

// https://leetcode.com/problems/to-lower-case/

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
//   Example 1:
//        Input: s = "Hello"
//        Output: "hello"
//   Example 2:
//        Input: s = "here"
//        Output: "here"
//   Example 3:
//        Input: s = "LOVELY"
//        Output: "lovely"
//   Constraints:
//        1 <= s.length <= 100
//        s consists of printable ASCII characters.
public class E709_ToLowerCase {
    public String toLowerCase(String s) {
        if (s == null)  return "";

        String rtn = "";
        char [] arrRtn = s.toCharArray();
        for (char c : arrRtn) {
            if (c >= 65 && c <= 90) {
                c = (char) (c + 32);
            }
            rtn = rtn + Character.toString(c);
        }

        return rtn;
    }

    @Test
    public void testToLowerCase() {
        String s = "Hello";
        String output = "hello";
        assertEquals(output, toLowerCase(s));

        s = "here";
        output = "here";
        assertEquals(output, toLowerCase(s));

        s = "LOVELY";
        output = "lovely";
        assertEquals(output, toLowerCase(s));
    }
}
