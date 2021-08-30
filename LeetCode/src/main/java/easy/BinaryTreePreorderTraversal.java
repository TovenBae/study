package easy;

/**
 https://leetcode.com/problems/binary-tree-preorder-traversal/

 Given the root of a binary tree, return the preorder traversal of its nodes' values.



 Example 1:


 Input: root = [1,null,2,3]
 Output: [1,2,3]
 Example 2:

 Input: root = []
 Output: []
 Example 3:

 Input: root = [1]
 Output: [1]
 Example 4:


 Input: root = [1,2]
 Output: [1,2]
 Example 5:


 Input: root = [1,null,2]
 Output: [1,2]


 Constraints:

 The number of nodes in the tree is in the range [0, 100].
 -100 <= Node.val <= 100


 Follow up: Recursive solution is trivial, could you do it iteratively?

 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {

        return null;
    }

    @Test
    public void test() {
        BinaryTreePreorderTraversal test = new BinaryTreePreorderTraversal();

        TreeNode root = new TreeNode();
        assertThat(test.preorderTraversal(root), equalTo(Arrays.asList(1,2,3)));
    }
}
