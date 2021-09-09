package easy;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Given an array of integers numbers that is already sorted in non-decreasing order, find two numbers such
 * that they add up to a specific target number.
 * * Return the indices of the two numbers (1-indexed) as an integer array answer of size 2,
 * where 1 <= answer[0] < answer[1] <= numbers.length.
 *
 * The tests are generated such that there is exactly one solution. You may not use the same element twice.
 *
 * Example 1:
     * Input: numbers = [2,7,11,15], target = 9
     * Output: [1,2]
     * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 * Example 2:
     * Input: numbers = [2,3,4], target = 6
     * Output: [1,3]
 * Example 3:
     * Input: numbers = [-1,0], target = -1
     * Output: [1,2]
 *
 * Constraints:
     * 2 <= numbers.length <= 3 * 10E4
     * -1000 <= numbers[i] <= 1000
     * numbers is sorted in non-decreasing order.
     * -1000 <= target <= 1000
 * The tests are generated such that there is exactly one solution.
 */
public class E167_TwoSumII {
    public int[] twoSum2(int[] numbers, int target) {
        if (numbers.length < 2) return null;

        for (int i=1; i<numbers.length; i++) {
            for (int j=0; j<i; j++) {
                if (target - numbers[j] - numbers[i] == 0)
                    return new int[]{j+1, i+1};
            }
        }
        return null;
    }

    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return null;

        int s = 0, e  = numbers.length -1;
        while(target != numbers[s] + numbers[e]) {
            if (target < numbers[s] + numbers[e]) e--;
            else s++;
        }
        return new int[]{s+1, e+1};
    }

    @Test
    public void test() {
        int [] numbers = {};
        int target;
        E167_TwoSumII test = new E167_TwoSumII();

        numbers = new int[]{2, 7, 11, 15};
        target = 9;
        assertThat(test.twoSum(numbers, target), equalTo(new int []{1,2}));

        numbers = new int[]{2,3,4};
        target = 6;
        assertThat(test.twoSum(numbers, target), equalTo(new int []{1,3}));

        numbers = new int[]{-1, 0};
        target = -1;
        assertThat(test.twoSum(numbers, target), equalTo(new int []{1,2}));

        numbers = new int[]{2, 7, 11, 15};
        target = 18;
        assertThat(test.twoSum(numbers, target), equalTo(new int []{2,3}));

        numbers = new int[]{0, 0, 3, 4};
        target = 0;
        assertThat(test.twoSum(numbers, target), equalTo(new int []{1,2}));

    }
}
