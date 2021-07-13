package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// https://leetcode.com/problems/remove-element/

// Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
// The relative order of the elements may be changed.
// Since it is impossible to change the length of the array in some languages,
// you must instead have the result be placed in the first part of the array nums.
// More formally, if there are k elements after removing the duplicates,
// then the first k elements of nums should hold the final result.
// It does not matter what you leave beyond the first k elements.

// Return k after placing the final result in the first k slots of nums.
// Do not allocate extra space for another array.
// You must do this by modifying the input array in-place with O(1) extra memory.

//Constraints:
//        0 <= nums.length <= 100
//        0 <= nums[i] <= 50
//        0 <= val <= 100
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int rtn = 0;


        return rtn;
    }

    @Test
    public void test() {
        RemoveElement test = new RemoveElement();
        int [] nums = {3,2,2,3};
        int val = 3;
        int output = 2;
        int [] expectedNums = {2,2};
        assertEquals(output, test.removeElement(nums, val));

        checkResult(output, nums, expectedNums);

        nums = new int[] {0,1,2,2,3,0,4,2};
        val = 2;
        output = 5;
        expectedNums = new int[] {0,1,4,0,3};
        assertEquals(output, test.removeElement(nums, val));

        checkResult(output, nums, expectedNums);

//        int [] nums2 = null;
//        output = 0; //
//        int [] expectedNums2 = null;
//        assertEquals(output, test.removeElement(nums2));
//
//        checkResult(output, nums2, expectedNums2);
//
//
//        int [] nums1 = {};
//        output = 0; //
//        int [] expectedNums1 = {}; // [];
//        assertEquals(output, test.removeElement(nums1));
//
//        checkResult(output, nums1, expectedNums1);

    }

    private void checkResult(int k, int [] nums, int [] expectedNums) {
        assert k == expectedNums.length;
//        sort(nums, 0, k); // Sort the first k elements of nums
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }
}
