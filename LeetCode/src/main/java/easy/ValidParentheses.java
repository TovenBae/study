package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/valid-parentheses/
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
// 1. Open brackets must be closed by the same type of brackets.
// 2. Open brackets must be closed in the correct order.
public class ValidParentheses {
    public boolean isValid(String s) {
        boolean isTrue = false;


        return isTrue;
    }

    @Test
    public void test() {
        ValidParentheses test = new ValidParentheses();
        String s = "()";
        boolean Output = true;
        assertEquals(Output, test.isValid(s));

        s = "()[]{}";
        Output = true;
        assertEquals(Output, test.isValid(s));

        s = "(]";
        Output = false;
        assertEquals(Output, test.isValid(s));

        s = "([)]";
        Output = false;
        assertEquals(Output, test.isValid(s));

        s = "{[]}";
        Output = true;
        assertEquals(Output, test.isValid(s));

    }
}
