package easy;

// https://leetcode.com/problems/search-insert-position/

//Given a sorted array of distinct integers and a target value, return the index if the target is found.
// If not, return the index where it would be if it were inserted in order.

import org.junit.Test;

import static org.junit.Assert.assertEquals;

//        You must write an algorithm with O(log n) runtime complexity.
//Constraints:
//
//        1 <= nums.length <= 104
//        -104 <= nums[i] <= 104
//        nums contains distinct values sorted in ascending order.
//        -104 <= target <= 104
public class E035_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (target <= nums[0]) return 0;
        else if(target > nums[nums.length-1]) return nums.length;
        else if (target == nums[nums.length-1]) return nums.length-1;

        int rtn = searchBTree(nums, nums.length / 2, target);
        return rtn;
    }

    private int searchBTree(int[] nums, int pos, int target) {
        if (pos == nums.length-1) return nums.length-1;
        else if (target == nums[pos]) return pos;
        else if (target == nums[pos-1]) return pos-1;
        else if (target == nums[pos+1]) return pos+1;
        else if (nums[pos-1] <= target && nums[pos+1] >= target) {
            if (target > nums[pos]) return pos+1;
            else return pos;
        }

        if (target < nums[pos]) {
            return searchBTree(nums, pos / 2, target);
        } else {
            return searchBTree(nums, pos + (pos / 2), target);
        }
    }

    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left + (right-left)/2;

            if(target == nums[mid])
                return mid;

            else if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        if(target <= nums[left])
            return left;
        else return left+1;

    }

    @Test
    public void test() {
        long startTime = System.nanoTime();
        E035_SearchInsertPosition test = new E035_SearchInsertPosition();
        int [] nums = {1,3,5,6};
        int target = 5;
        int output = 2;
        assertEquals(output, test.searchInsert(nums, target));

        nums = new int[] {1,3,5,6};
        target = 2;
        output = 1;
        assertEquals(output, test.searchInsert(nums, target));

        nums = new int[] {1,3,5,6};
        target = 7;
        output = 4;
        assertEquals(output, test.searchInsert(nums, target));

        nums = new int[] {1,3,5,6};
        target = 0;
        output = 0;
        assertEquals(output, test.searchInsert(nums, target));

        nums = new int[] {1};
        target = 0;
        output = 0;
        assertEquals(output, test.searchInsert(nums, target));

        // Exception
        nums = new int[] {1,3,5,6,8,10};
        target = 7;
        output = 4;
        assertEquals(output, test.searchInsert(nums, target));

        nums = new int[] {1,3};
        target = 3;
        output = 1;
        assertEquals(output, test.searchInsert(nums, target));

        nums = new int[] {1,3,5};
        target = 4;
        output = 2;
        assertEquals(output, test.searchInsert(nums, target));

        nums = new int[] {1,4,6,7,8,9};
        target = 6;
        output = 2;
        assertEquals(output, test.searchInsert(nums, target));
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);

    }

    @Test
    public void test2() {
        long startTime = System.nanoTime();
        E035_SearchInsertPosition test = new E035_SearchInsertPosition();
        int [] nums = {1,3,5,6};
        int target = 5;
        int output = 2;
        assertEquals(output, test.searchInsert2(nums, target));

        nums = new int[] {1,3,5,6};
        target = 2;
        output = 1;
        assertEquals(output, test.searchInsert2(nums, target));

        nums = new int[] {1,3,5,6};
        target = 7;
        output = 4;
        assertEquals(output, test.searchInsert2(nums, target));

        nums = new int[] {1,3,5,6};
        target = 0;
        output = 0;
        assertEquals(output, test.searchInsert2(nums, target));

        nums = new int[] {1};
        target = 0;
        output = 0;
        assertEquals(output, test.searchInsert2(nums, target));

        // Exception
        nums = new int[] {1,3,5,6,8,10};
        target = 7;
        output = 4;
        assertEquals(output, test.searchInsert2(nums, target));

        nums = new int[] {1,3};
        target = 3;
        output = 1;
        assertEquals(output, test.searchInsert2(nums, target));

        nums = new int[] {1,3,5};
        target = 4;
        output = 2;
        assertEquals(output, test.searchInsert2(nums, target));

        nums = new int[] {1,4,6,7,8,9};
        target = 6;
        output = 2;
        assertEquals(output, test.searchInsert2(nums, target));
        long stopTime = System.nanoTime();
        System.out.println(stopTime - startTime);

    }
}
