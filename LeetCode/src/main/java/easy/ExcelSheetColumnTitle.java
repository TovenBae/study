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

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        // "A" : 65
        int mok = columnNumber / 26;
        int rest = columnNumber % 26;
        String columnTitle = "";
        while(mok > 0) {
            columnTitle += Character.toString((char)(mok + 64));
            mok = mok / 26;
        }
        columnTitle += Character.toString((char)(rest + 64));
        return columnTitle;
    }

    @Test
    public void test() {
        ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();

        assertThat(test.convertToTitle(1), equalTo("A"));

        assertThat(test.convertToTitle(28), equalTo("AB"));

        assertThat(test.convertToTitle(701), equalTo("ZY"));

        assertThat(test.convertToTitle(2147483647), equalTo("FXSHRXW"));
    }
}
