package easy;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//https://leetcode.com/problems/same-tree/
//
//        Given the roots of two binary trees p and q, write a function to check if they are the same or not.
//        Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
//
//    Example 1:
//        Input: p = [1,2,3], q = [1,2,3]
//        Output: true
//    Example 2:
//        Input: p = [1,2], q = [1,null,2]
//        Output: false
//    Example 3:
//        Input: p = [1,2,1], q = [1,1,2]
//        Output: false
//
//    Constraints:
//        The number of nodes in both trees is in the range [0, 100].
//        -10E4 <= Node.val <= 10E4

/**
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
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null)
            return true;
        else if (p == null || q == null)
            return false;
        else if (p.val != q.val)
            return false;

        if (!isSameTree(p.left, q.left)) {
            return false;
        }

        if (!isSameTree(p.right, q.right)) {
            return false;
        }

        return true;
    }

    // Approach 1: Recursion
    public boolean isSameTree2(TreeNode p, TreeNode q) {
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
        SameTree test = new SameTree();

        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        boolean output = true;
        boolean isEqual = test.isSameTree(p, q);
        assertThat(isEqual, equalTo(output));

        p = new TreeNode(1, new TreeNode(2), null);
        q = new TreeNode(1, null, new TreeNode(2));
        output = false;
        isEqual = test.isSameTree(p, q);
        assertThat(isEqual, equalTo(output));

        p = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        q = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        output = false;
        isEqual = test.isSameTree(p, q);
        assertThat(isEqual, equalTo(output));

//        [10,5,15]
//        [10,5,null,null,15]
//        false
        p = new TreeNode(10, new TreeNode(5), new TreeNode(15));
        q = new TreeNode(5, null, new TreeNode(15));
        q = new TreeNode(10, q, null);
        output = false;
        isEqual = test.isSameTree(p, q);
        assertThat(isEqual, equalTo(output));

    }
}
