package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/longest-common-prefix/

// Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String rtn = "";

        return rtn;
    }

    @Test
    public void test() {
        LongestCommonPrefix test = new LongestCommonPrefix();
        String [] strs = {"flower", "flow", "flight"};
        String Output = "fl";
        assertEquals(Output, test.longestCommonPrefix(strs));

        strs = new String[] {"dog", "racecar", "car"};
        Output = "";
        assertEquals(Output, test.longestCommonPrefix(strs));

    }
}
