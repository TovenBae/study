package easy;

// https://leetcode.com/problems/excel-sheet-column-title/

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
 *
 * For example:
 *
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 *
 *
 * Example 1:
     * Input: columnNumber = 1
     * Output: "A"
 * Example 2:
     * Input: columnNumber = 28
     * Output: "AB"
 * Example 3:
     * Input: columnNumber = 701
     * Output: "ZY"
 * Example 4:
     * Input: columnNumber = 2147483647
     * Output: "FXSHRXW"
 *
 * Constraints:
 * 1 <= columnNumber <= 2E31 - 1
 */

public class E168_ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        String columnTitle = "";

        while(--columnNumber >= 0) {
            columnTitle = (char)(columnNumber % 26 + 'A') + columnTitle;
            columnNumber /= 26;
        }
        return columnTitle;
    }

     @Test
    public void test() {
        E168_ExcelSheetColumnTitle test = new E168_ExcelSheetColumnTitle();

        assertThat(test.convertToTitle(1), equalTo("A"));

        assertThat(test.convertToTitle(26), equalTo("Z"));

        assertThat(test.convertToTitle(27), equalTo("AA"));

        assertThat(test.convertToTitle(28), equalTo("AB"));

        assertThat(test.convertToTitle(701), equalTo("ZY"));

        assertThat(test.convertToTitle(702), equalTo("ZZ"));

        assertThat(test.convertToTitle(703), equalTo("AAA"));

        assertThat(test.convertToTitle(2147483647), equalTo("FXSHRXW"));
    }
}
