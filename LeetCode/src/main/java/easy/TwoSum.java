package easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int [] rtn = {0, 0};

        for (int i=0; i<nums.length; i++) {
            int b = target - nums[i];
            for (int j=(i+1); j<nums.length; j++) {
                if (b == nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        return rtn;
    }

    @Test
    public void testTowSum() {
        TwoSum ts = new TwoSum();
        int [] nums = {2,7,11,15};
        int target = 9;
        int [] output = {0,1};
        Assert.assertArrayEquals(output, ts.twoSum(nums, target));
//        assertEquals(output, ts.twoSum(nums, target));

        nums = new int[]{3, 2, 4};
        target = 6;
        output = new int[]{1,2};
        Assert.assertArrayEquals(output, ts.twoSum(nums, target));

        nums = new int[]{3, 3};
        target = 6;
        output = new int[] {0,1};
        Assert.assertArrayEquals(output, ts.twoSum(nums, target));
    }

}
