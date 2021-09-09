package easy;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

// Given an integer array nums where the elements are sorted in ascending order,
// convert it to a height-balanced binary search tree.
// A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
//
//    Example 1:
//        Input: nums = [-10,-3,0,5,9]
//        Output: [0,-3,9,-10,null,5]
//        Explanation: [0,-10,5,null,-3,null,9] is also accepted:
//
//    Example 2:
//        Input: nums = [1,3]
//        Output: [3,1]
//        Explanation: [1,3] and [3,1] are both a height-balanced BSTs.
//
//    Constraints:
//
//        1 <= nums.length <= 10E4
//        -10E4 <= nums[i] <= 10E4
//        nums is sorted in a strictly increasing order.
/**
 *
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class E108_ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null) {
            return null;
        } else if (nums.length == 1) {
            return new TreeNode(nums[0]);
        } else if (nums.length == 2) {
//            return new TreeNode(nums[0], null, new TreeNode(nums[1]));
            return new TreeNode(nums[1], new TreeNode(nums[0]), null);
        } else if (nums.length == 3) {
            return new TreeNode(nums[1], new TreeNode(nums[0]), new TreeNode(nums[2]));
        }

        TreeNode result = new TreeNode();
        int midPos = nums.length / 2 + nums.length % 2 - 1;

        result.val = nums[midPos];
        result.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, midPos));
        result.right = sortedArrayToBST(Arrays.copyOfRange(nums, midPos+1, nums.length));

        return result;
    }

    // Solution #1
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }

   @Test
    public void test() {
        E108_ConvertSortedArraytoBinarySearchTree test = new E108_ConvertSortedArraytoBinarySearchTree();
        TreeNode output = null;
        TreeNode sub = null;

//        1,2,3,4,5,6,7,8,9,10
//                    5
//               3         8
//            2   4    7    10
//        1          6     9

        //        1,2,3,4,5,6,7,8,9,10,11,12,13,14
//                      7
//               3                11
//            2       5      9          13
//          1       4   6   8   10    12  14

        int [] nums = {-10,-3,0,5,9};
//              0
//           -3     9
//        -10     5
        // output = {0,-3,9,-10,null,5};
        output = new TreeNode(0);
        sub = new TreeNode(-3, new TreeNode(-10), null);
        output.left = sub;
        sub = new TreeNode(9, new TreeNode(5), null);
        output.right = sub;
        TreeNode result = test.sortedArrayToBST(nums);
        assertThat(isSameTree(result, output), equalTo(true));

        nums = new int[]{1,3};
        // output = {3,1} or {1,3};
//        output = new TreeNode(1, null, new TreeNode(3));
        output = new TreeNode(3,  new TreeNode(1), null);
        result = test.sortedArrayToBST(nums);
        assertThat(isSameTree(result, output), equalTo(true));

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // p and q are both null
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }
}
