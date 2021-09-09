package easy;


//https://leetcode.com/problems/implement-strstr/

// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// Clarification:
//What should we return when needle is an empty string? This is a great question to ask during an interview.
//For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

//Constraints:
//
//        0 <= haystack.length, needle.length <= 5 * 104
//        haystack and needle consist of only lower-case English characters.
//        do not use indexOf() of String

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class E028_ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() > haystack.length())
            return -1;
        else if (needle.length() == 0)
            return 0;
        else if (haystack.equals(needle)) {
            return 0;
        }

        char c = needle.charAt(0);
        for (int i=0; i<= haystack.length()-needle.length(); i++) {
            if (haystack.charAt(i) == c &&
                haystack.substring(i, i+needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    @Test
    public void test() {
        E028_ImplementstrStr test = new E028_ImplementstrStr();
        String haystack = "hello";
        String needle = "ll";
        int output = 2;
        assertEquals(output, test.strStr(haystack, needle));

        haystack = "aaaaa";
        needle = "bba";
        output = -1;
        assertEquals(output, test.strStr(haystack, needle));

        haystack = "";
        needle = "";
        output = 0;
        assertEquals(output, test.strStr(haystack, needle));

        // exception test case
        haystack = "mississippi";
        needle = "issipi";
        output = -1;
        assertEquals(output, test.strStr(haystack, needle));

        haystack = "mississippi";
        needle = "issip";
        output = 4;
        assertEquals(output, test.strStr(haystack, needle));

        haystack = "a";
        needle = "a";
        output = 0;
        assertEquals(output, test.strStr(haystack, needle));

        haystack = "a";
        needle = "ab";
        output = -1;
        assertEquals(output, test.strStr(haystack, needle));

        haystack = "abab";
        needle = "a";
        output = 0;
        assertEquals(output, test.strStr(haystack, needle));

        haystack = "abc";
        needle = "c";
        output = 2;
        assertEquals(output, test.strStr(haystack, needle));

        haystack = "abc";
        needle = "bc";
        output = 1;
        assertEquals(output, test.strStr(haystack, needle));

    }

    @Test
    public void test2() {
        E028_ImplementstrStr test = new E028_ImplementstrStr();
        String haystack = "hello";
        String needle = "ll";
        int output = 2;
        assertEquals(output, test.strStr2(haystack, needle));

        haystack = "aaaaa";
        needle = "bba";
        output = -1;
        assertEquals(output, test.strStr2(haystack, needle));

        haystack = "";
        needle = "";
        output = 0;
        assertEquals(output, test.strStr2(haystack, needle));
    }

}
