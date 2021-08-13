package easy;

import org.junit.Test;

import java.util.Stack;
import java.util.Vector;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/valid-parentheses/
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
// 1. Open brackets must be closed by the same type of brackets.
// 2. Open brackets must be closed in the correct order.
public class ValidParentheses {
    public boolean isValid(String s) {
        boolean isTrue = true;
        Vector vec = new Vector();
        for (int i=0; i<s.length(); i++) {
            checkOpenChar(s.charAt(i), vec);
            if (!checkCloseChar(s.charAt(i), vec))
                return false;
        }

        if (vec.size() > 0)
            return false;

        return isTrue;
    }

    private boolean checkOpenChar(char c, Vector vec) {
        switch (c) {
            case '(' :
            case '{' :
            case '[' :
                vec.add(c);
                return true;
            default :
                return false;
        }
    }

    private boolean checkCloseChar(char c, Vector vec) {
        if (vec.size() == 0) return false;

        switch (c) {
            case ')' :
                return checkMatchChar('(', vec);
            case '}' :
                return checkMatchChar('{', vec);
            case ']' :
                return checkMatchChar('[', vec);
            default :
                return true;
        }
    }

    private boolean checkMatchChar(char c, Vector vec) {
        char ch = (char)vec.get(vec.size()-1);
        if (ch == c) {
            vec.remove(vec.size()-1);
            return true;
        }
        return false;
    }

    // solution
    public boolean isValid_sol(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            if(a == '(' || a == '[' || a == '{') stack.push(a);
            else if(stack.empty()) return false;
            else if(a == ')' && stack.pop() != '(') return false;
            else if(a == ']' && stack.pop() != '[') return false;
            else if(a == '}' && stack.pop() != '{') return false;
        }
        return stack.empty();
    }

    @Test
    public void test() {
        ValidParentheses test = new ValidParentheses();
        String s = "()";
        boolean Output = true;
        assertEquals(Output, test.isValid_sol(s));

        s = "()[]{}";
        Output = true;
        assertEquals(Output, test.isValid_sol(s));

        s = "(]";
        Output = false;
        assertEquals(Output, test.isValid_sol(s));

        s = "([)]";
        Output = false;
        assertEquals(Output, test.isValid_sol(s));

        s = "{[]}";
        Output = true;
        assertEquals(Output, test.isValid(s));

        s = "{";
        Output = false;
        assertEquals(Output, test.isValid(s));

        s = "]";
        Output = false;
        assertEquals(Output, test.isValid(s));

    }
}
