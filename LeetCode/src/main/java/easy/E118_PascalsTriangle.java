package easy;

// https://leetcode.com/problems/pascals-triangle/

// Given an integer numRows, return the first numRows of Pascal's triangle.
// In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
//
//    Example 1:
//        Input: numRows = 5
//        Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//    Example 2:
//        Input: numRows = 1
//        Output: [[1]]
//    Constraints:
//        1 <= numRows <= 30

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class E118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0)
            return new ArrayList<>();

        List<List<Integer>> lList = new ArrayList<>();
        lList.add(Arrays.asList(1));
        for (int i=1; i<numRows; i++) {
            List<Integer> preList = lList.get(i-1);
            List<Integer> list = new ArrayList<Integer>();
            list.add(preList.get(0));
            for(int j=0; j<preList.size()-1; j++) {
                list.add(preList.get(j) + preList.get(j+1));
            }
            list.add(preList.get(preList.size()-1));
            lList.add(list);
        }
        return lList;
    }

    @Test
    public void test() {
        E118_PascalsTriangle test = new E118_PascalsTriangle();

        List<List<Integer>> output = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(1,1),
                Arrays.asList(1,2,1),
                Arrays.asList(1,3,3,1),
                Arrays.asList(1,4,6,4,1));
        assertThat(test.generate(5), equalTo(output));

        output = Arrays.asList(Arrays.asList(1));
        assertThat(test.generate(1), equalTo(output));
    }
}
