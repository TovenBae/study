package easy;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

//Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
//        Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
//        Return k after placing the final result in the first k slots of nums.

import static org.junit.Assert.assertEquals;

//Constraints:
//        0 <= nums.length <= 3 * 104
//        -100 <= nums[i] <= 100
//        nums is sorted in non-decreasing order.
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int rtn = 0;

        return rtn;
    }

    public void test() {
        RemoveDuplicatesfromSortedArray test = new RemoveDuplicatesfromSortedArray();
        int [] nums = {1, 1, 2};
        int Output = 2; // [1,2,_]
        int [] expectedNums = {1,2};
        assertEquals(Output, test.removeDuplicates(nums));

        assert Output == expectedNums.length;
        for (int i = 0; i < Output; i++) {
            assert nums[i] == expectedNums[i];
        }

        nums = new int[] {0,0,1,1,1,2,2,3,3,4};
        Output = 5; //
        expectedNums = new int[] {0,1,2,3,4};// [0,1,2,3,4,_,_,_,_,_]
        assertEquals(Output, test.removeDuplicates(nums));

        assert Output == expectedNums.length;
        for (int i = 0; i < Output; i++) {
            assert nums[i] == expectedNums[i];
        }

    }

}
