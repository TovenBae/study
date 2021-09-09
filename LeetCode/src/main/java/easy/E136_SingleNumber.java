package easy;

//https://leetcode.com/problems/single-number/

//  Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//  You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//    Example 1:
//
//        Input: nums = [2,2,1]
//        Output: 1
//    Example 2:
//
//        Input: nums = [4,1,2,1,2]
//        Output: 4
//    Example 3:
//
//        Input: nums = [1]
//        Output: 1
//
//    Constraints:
//
//        1 <= nums.length <= 3 * 10E4
//        -3 * 10E4 <= nums[i] <= 3 * 10E4
//        Each element in the array appears twice except for one element which appears only once.

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class E136_SingleNumber {
    public int singleNumber_1(int[] nums) {
        Map<Integer, Integer> reserve = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++) {
            if (reserve.get(nums[i]) != null) {
                int val = reserve.get(nums[i]);
                reserve.put(nums[i], ++val);
            } else {
                reserve.put(nums[i], 1);
            }
        }
        Iterator<Integer> keys = reserve.keySet().iterator();
        while(keys.hasNext()) {
            int key = keys.next();
            if (reserve.get(key) == 1)
                return key;
        }
        return -1;
    }

    // solution 1
    // https://beccacatcheserrors.tistory.com/11?category=836078
    public int singleNumber(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        int res = 0;

        for (int e: nums) {
            res ^= e;
        }

        return res;
    }

    // solution 2
    public int singleNumber2(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        for(int i=0;i<nums.length-1;i+=2){
            if(nums[i]!=nums[i+1]){
                a = nums[i];
                break;
            }
            else{
                a = nums[nums.length-1];
            }
        }
        return a;
    }

    @Test
    public void test() {
        E136_SingleNumber test = new E136_SingleNumber();
        int [] nums;

        nums = new int[]{2,2,1};
        assertThat(test.singleNumber(nums), equalTo(1));

        nums = new int[]{4,1,2,1,2};
        assertThat(test.singleNumber(nums), equalTo(4));

        nums = new int[]{1};
        assertThat(test.singleNumber(nums), equalTo(1));

    }

}
