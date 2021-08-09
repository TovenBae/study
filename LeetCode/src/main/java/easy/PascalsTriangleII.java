package easy;

// https://leetcode.com/problems/pascals-triangle-ii/

// Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//    Example 1:
//        Input: rowIndex = 3
//        Output: [1,3,3,1]
//
//    Example 2:
//        Input: rowIndex = 0
//        Output: [1]
//
//    Example 3:
//        Input: rowIndex = 1
//        Output: [1,1]
//
//    Constraints:
//        0 <= rowIndex <= 33

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0)
            return Arrays.asList(1);
        else if (rowIndex == 1)
            return Arrays.asList(1,1);

        List<Integer> preList = new ArrayList();
        List<Integer> list = new ArrayList<>();
        preList.add(1);
        preList.add(1);
        for (int i=1; i<rowIndex; i++) {
            list = new ArrayList();
            list.add(1);
            for (int j=0; j<preList.size()-1; j++) {
                list.add(preList.get(j) + preList.get(j+1));
            }
            preList = new ArrayList(list);
            preList.add(1);
        }
        list.add(1);
        return list;
    }


    // solution
    public List<Integer> getRow2(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= k; i++)
            for (int j = i; j > 0; j--)
                arr[j] = arr[j] + arr[j - 1];

        return Arrays.asList(arr);
    }

    @Test
    public void test() {
        PascalsTriangleII test = new PascalsTriangleII();

        assertThat(test.getRow(3), equalTo(Arrays.asList(1,3,3,1)));

        assertThat(test.getRow(4), equalTo(Arrays.asList(1,4,6,4,1)));

        assertThat(test.getRow(0), equalTo(Arrays.asList(1)));

        assertThat(test.getRow(1), equalTo(Arrays.asList(1,1)));
    }
}
