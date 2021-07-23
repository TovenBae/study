package easy;

import org.junit.Test;

import static org.junit.Assert.*;
//import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.Matchers.equalTo;

//https://leetcode.com/problems/merge-sorted-array/

// You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
// and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
// Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//
// The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
// To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
// and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
//
// Example 1:
//        Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//        Output: [1,2,2,3,5,6]
//        Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
//        The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
//
// Example 2:
//        Input: nums1 = [1], m = 1, nums2 = [], n = 0
//        Output: [1]
//        Explanation: The arrays we are merging are [1] and [].
//        The result of the merge is [1].
//
//  Example 3:
//        Input: nums1 = [0], m = 0, nums2 = [1], n = 1
//        Output: [1]
//        Explanation: The arrays we are merging are [] and [1].
//        The result of the merge is [1].
//        Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
//
//
//  Constraints:
//        nums1.length == m + n
//        nums2.length == n
//        0 <= m, n <= 200
//        1 <= m + n <= 200
//        -10E9 <= nums1[i], nums2[j] <= 10E9

public class MergeSortedArray {
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int j = 0;
        for (int i=0; i<m+j; i++) {
            while(j<n && nums1[i]>nums2[j]) {
                for(int k=m+n-1; k>i; k--) {
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                i++;
                j++;
            }
        }
        while(j<n) {
            nums1[m+n-1] = nums2[n-1];
            n--;
        }
    }

    // solution
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1, tail2 = n - 1, finished = m + n - 1;
        while (tail1 >= 0 && tail2 >= 0) {
            nums1[finished--] = (nums1[tail1] > nums2[tail2]) ?
                    nums1[tail1--] : nums2[tail2--];
        }

        while (tail2 >= 0) { //only need to combine with remaining nums2
            nums1[finished--] = nums2[tail2--];
        }
    }

    @Test
    public void test() {
        MergeSortedArray test = new MergeSortedArray();

        int [] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int [] nums2 = {2,5,6};
        int n = 3;
        int [] output = {1,2,2,3,5,6};
        merge(nums1, m, nums2, n);
        checkResult(output, nums1);

        nums1 = new int[]{1};
        m = 1;
        nums2 = new int[]{};
        n = 0;
        output = new int[]{1};
        merge(nums1, m, nums2, n);
        checkResult(output, nums1);

        nums1 = new int[]{0};
        m = 0;
        nums2 = new int[]{1};
        n = 1;
        output = new int[]{1};
        merge(nums1, m, nums2, n);
        checkResult(output, nums1);

        nums1 = new int[]{0,0,3,0,0,0,0,0,0};
        m = 3;
        nums2 = new int[]{-1,1,1,1,2,3};
        n = 6;
        output = new int[]{-1,0,0,1,1,1,2,3,3};
        merge(nums1, m, nums2, n);
        checkResult(output, nums1);

    }

    private void checkResult(int[] output, int[] nums) {
        for (int i=0;i<output.length; i++) {
            System.out.println("i : " + i);
            assertThat(nums[i], equalTo(output[i]));
        }
    }
}
