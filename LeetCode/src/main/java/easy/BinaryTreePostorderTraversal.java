package easy;

/**

 https://leetcode.com/problems/binary-tree-postorder-traversal/

 Given the root of a binary tree, return the postorder traversal of its nodes' values.

 Example 1:
     Input: root = [1,null,2,3]
     Output: [3,2,1]
 Example 2:
     Input: root = []
     Output: []
 Example 3:
     Input: root = [1]
     Output: [1]
 Example 4:
     Input: root = [1,2]
     Output: [2,1]
 Example 5:
     Input: root = [1,null,2]
     Output: [2,1]

 Constraints:
     The number of the nodes in the tree is in the range [0, 100].
     -100 <= Node.val <= 100

 Follow up: Recursive solution is trivial, could you do it iteratively?
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null)
            return Arrays.asList();

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.isEmpty()) {
            if (root.left != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (root.right != null) {
                    root = root.right;
                } else {
                    result.add(root.val);
                    root = stack.pop();
                    result.add(root.val);
                    root = root.right;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        BinaryTreePostorderTraversal test = new BinaryTreePostorderTraversal();

        TreeNode root = new TreeNode();

        // [1,null,2,3]
        root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        assertThat(test.postorderTraversal(root), equalTo(Arrays.asList(3,2,1)));

        root = null;
        assertThat(test.postorderTraversal(root), equalTo(Arrays.asList()));

        root = new TreeNode(1);
        assertThat(test.postorderTraversal(root), equalTo(Arrays.asList(1)));

        root = new TreeNode(1, new TreeNode(2), null);
        assertThat(test.postorderTraversal(root), equalTo(Arrays.asList(2,1)));

        root = new TreeNode(1, null, new TreeNode(2));
        assertThat(test.postorderTraversal(root), equalTo(Arrays.asList(2, 1)));

        // [1,4,3,2]
        root = new TreeNode(1, new TreeNode(4, new TreeNode(2), null), new TreeNode(3));
        assertThat(test.postorderTraversal(root), equalTo(Arrays.asList(2,4,3,1)));
    }
}
