package easy;

// https://leetcode.com/problems/excel-sheet-column-number/

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
Given a string columnTitle that represents the column title as appear in an Excel sheet,
 return its corresponding column number.

        For example:

        A -> 1
        B -> 2
        C -> 3
        ...
        Z -> 26
        AA -> 27
        AB -> 28
        ...

Example 1:

        Input: columnTitle = "A"
        Output: 1
Example 2:

        Input: columnTitle = "AB"
        Output: 28
Example 3:

        Input: columnTitle = "ZY"
        Output: 701
Example 4:

        Input: columnTitle = "FXSHRXW"
        Output: 2147483647


Constraints:

        1 <= columnTitle.length <= 7
        columnTitle consists only of uppercase English letters.
        columnTitle is in the range ["A", "FXSHRXW"].
*/

public class E171_ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        char [] ch = columnTitle.toCharArray();

        int j=1;
        for(int i=ch.length-1; i>=0; i--) {
            result += (ch[i]  - 64) * j;
            j *= 26;
        }
        return result;
    }

    // Solution
    public int titleToNumber_sol(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++)
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        return result;
    }

    @Test
    public void test() {
        E171_ExcelSheetColumnNumber test = new E171_ExcelSheetColumnNumber();

        assertThat(test.titleToNumber("A"), equalTo(1));

        assertThat(test.titleToNumber("AB"), equalTo(28));

        assertThat(test.titleToNumber("ZY"), equalTo(701));

        assertThat(test.titleToNumber("FXSHRXW"), equalTo(2147483647));
    }
}
