package easy;

//https://leetcode.com/problems/maximum-subarray/

//Given an integer array nums, find the contiguous subarray (containing at least one number)
// which has the largest sum and return its sum.
//
//        Example 1:
//        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//        Output: 6
//        Explanation: [4,-1,2,1] has the largest sum = 6.

//        Example 2:
//        Input: nums = [1]
//        Output: 1

//        Example 3:
//        Input: nums = [5,4,-1,7,8]
//        Output: 23
//
//        Constraints:
//        1 <= nums.length <= 3 * 10E4
//        -10E5 <= nums[i] <= 10E5

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class E053_MaximumSubarray {
    public int maxSubArray3(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int maxVal = nums[0];
        for (int i=0; i<nums.length; i++) {
            int sum = 0;
            for (int j=i; j<nums.length; j++) {
                sum += nums[j];
                maxVal = sum > maxVal? sum : maxVal;
            }
        }

        return maxVal;
    }

    public int maxSubArray(int[] nums) {

        int sum = nums[0];
        int max = nums[0];
        if(nums.length == 1){
            return max;
        }
        for(int i = 1; i<=nums.length-1 ; i++){

            if(sum < 0 ){
                sum = 0;
            }
            sum  = sum + nums[i];
            if(sum > max){
                max = sum;
            }

        }
        return max;
    }

    public int maxSubArray2(int[] nums) {
        int r = nums[0];
        int sum = nums[0];
        for(int i = 1;i < nums.length;i++)
        {
            sum = Math.max(nums[i],nums[i]+sum);
            r = Math.max(r,sum);
        }
        return r;
    }


    @Test
    public void test() {
        E053_MaximumSubarray test = new E053_MaximumSubarray();

        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int output = 6;
        assertEquals(output, test.maxSubArray(nums));

        nums = new int[] {1};
        output = 1;
        assertEquals(output, test.maxSubArray(nums));

        nums = new int[] {5,4,-1,7,8};
        output = 23;
        assertEquals(output, test.maxSubArray(nums));

        nums = new int[] {-1};
        output = -1;
        assertEquals(output, test.maxSubArray(nums));

        nums = new int[] {-1, 2};
        output = 2;
        assertEquals(output, test.maxSubArray(nums));

        nums = new int[] {-1, -2};
        output = -1;
        assertEquals(output, test.maxSubArray(nums));

        nums = new int[] {-1, -2, -5};
        output = -1;
        assertEquals(output, test.maxSubArray(nums));

        nums = new int[] {-5, -2, -1};
        output = -1;
        assertEquals(output, test.maxSubArray(nums));

        // 50, -10, -20, 1, 1, 1
    }

}
