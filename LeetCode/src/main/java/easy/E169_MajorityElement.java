package easy;

// https://leetcode.com/problems/majority-element/

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
Given an array nums of size n, return the majority element.
The majority element is the element that appears more than [n/2] times.  과반수
You may assume that the majority element always exists in the array.

Example 1:
        Input: nums = [3,2,3]
        Output: 3
Example 2:
        Input: nums = [2,2,1,1,1,2,2]
        Output: 2


Constraints:
        n == nums.length
        1 <= n <= 5 * 10E4
        -2E31 <= nums[i] <= 2E31 - 1

        Follow-up: Could you solve the problem in linear time and in O(1) space?
*/

public class E169_MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        Arrays.sort(nums);
        int tCnt = 1;
        for (int i=1; i<nums.length; i++) {
            tCnt++;
            if (tCnt > nums.length / 2) {
                return nums[i];
            }
            if (nums[i-1] < nums[i])
                tCnt = 1;
        }
        return 0;
    }

    // Approach 1: Brute Force
    //  - Time complexity : O(n^2)
    //  - Space complexity : O(1)
    public int majorityElement_sol1(int[] nums) {
        int majorityCount = nums.length/2;

        for (int num : nums) {
            int count = 0;
            for (int elem : nums) {
                if (elem == num) {
                    count += 1;
                }
            }

            if (count > majorityCount) {
                return num;
            }
        }

        return -1;
    }

    // Approach 2: HashMap
    //  - Time complexity : O(n)
    //  - Space complexity : O(n)
    private Map<Integer, Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) {
                counts.put(num, 1);
            }
            else {
                counts.put(num, counts.get(num)+1);
            }
        }
        return counts;
    }

    public int majorityElement_sol2(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getKey();
    }

    // Approach 3: Sorting
    //  - Time complexity : O(nlgn)
    //  - Space complexity : O(1) or O(n)
    public int majorityElement_sol3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // Approach 6: Boyer-Moore Voting Algorithm
    //  - Time complexity : O(n)
    //  - Space complexity : O(1)
    public int majorityElement_sol4(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    @Test
    public void test() {
        E169_MajorityElement test = new E169_MajorityElement();

        assertThat(test.majorityElement_sol3(new int[]{3,2,3}), equalTo(3));

        assertThat(test.majorityElement_sol3(new int[]{2,2,1,1,1,2,2}), equalTo(2));

        assertThat(test.majorityElement(new int[]{1}), equalTo(1));

        assertThat(test.majorityElement_sol4(new int[]{2,2,1,1,1,1,1,1,2,3,3}), equalTo(1));

        assertThat(test.majorityElement(new int[]{2,2}), equalTo(2));
    }
}
