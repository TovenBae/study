package easy;

import org.junit.Test;
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
public class ConvertSortedArraytoBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode result = new TreeNode();

        int midPos = nums.length / 2;


        return result;
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

    @Test
    public void test() {
        ConvertSortedArraytoBinarySearchTree test = new ConvertSortedArraytoBinarySearchTree();
        TreeNode output = null;
        TreeNode sub = null;

        1,2,3,4,5,6,7,8,9,10

                 6
            2         8
        1      3
        int [] nums = {-10,-3,0,5,9};
        // output = {0,-3,9,-10,null,5};
        output = new TreeNode(0);
        sub = new TreeNode(-3, new TreeNode(-10), null);
        output.left = sub;
        sub = new TreeNode(9, new TreeNode(5), null);
        output.right = sub;
        TreeNode result = test.sortedArrayToBST(nums);
        assertThat(isSameTree(result, output), equalTo(true));

        nums = new int[]{1,3};
        // output = {3,1};
        output = new TreeNode(3, null, new TreeNode(1));
        result = test.sortedArrayToBST(nums);
        assertThat(isSameTree(result, output), equalTo(true));

    }
}
