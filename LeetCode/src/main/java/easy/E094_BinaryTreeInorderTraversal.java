package easy;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

//https://leetcode.com/problems/binary-tree-inorder-traversal/

//Given the root of a binary tree, return the inorder traversal of its nodes' values.
//
//    Example 1:
//        Input: root = [1,null,2,3]
//        Output: [1,3,2]
//    Example 2:
//        Input: root = []
//        Output: []
//    Example 3:
//        Input: root = [1]
//        Output: [1]
//    Example 4:
//        Input: root = [1,2]
//        Output: [2,1]
//    Example 5:
//        Input: root = [1,null,2]
//        Output: [1,2]
//
//    Constraints:
//        The number of nodes in the tree is in the range [0, 100].
//        -100 <= Node.val <= 100
//
//        Follow up: Recursive solution is trivial, could you do it iteratively?

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

public class E094_BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null)
            return result;

        // traversal left
        if (root.left != null) {
            result.addAll(inorderTraversal(root.left));
        }

        // traversal node
        result.add(root.val);

        // traversal right
        if (root.right != null) {
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }

    // ref - Solution : Approach 1: Recursive Approach
    public List < Integer > inorderTraversal1(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List < Integer > res) {
        if (root != null) {
            if (root.left != null) {
                helper(root.left, res);
            }
            res.add(root.val);
            if (root.right != null) {
                helper(root.right, res);
            }
        }
    }

    // ref - Approach 2: Iterating method using Stack
    public List < Integer > inorderTraversal2(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack< TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    @Test
    public void Test() {
        E094_BinaryTreeInorderTraversal test = new E094_BinaryTreeInorderTraversal();

        TreeNode root = new TreeNode(2, new TreeNode(3), null);
        root = new TreeNode(1, null, root);
        List<Integer> output = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,3,2}));
        List<Integer> result = test.inorderTraversal(root);
        checkResult(result, output);

        root = new TreeNode();
        output = new ArrayList<Integer>();
        result = test.inorderTraversal(root);
        checkResult(result, output);

        root = new TreeNode(1);
        output = new ArrayList<Integer>(Arrays.asList(new Integer[]{1}));
        result = test.inorderTraversal(root);
        checkResult(result, output);

        root = new TreeNode(1, new TreeNode(2), null);
        output = new ArrayList<Integer>(Arrays.asList(new Integer[]{2, 1}));
        result = test.inorderTraversal(root);
        checkResult(result, output);

        root = new TreeNode(1, null, new TreeNode(2));
        output = new ArrayList<Integer>(Arrays.asList(new Integer[]{1, 2}));
        result = test.inorderTraversal(root);
        checkResult(result, output);

    }

    private void checkResult(List<Integer> root, List<Integer> output) {
        for (int i=0; i<output.size(); i++) {
            assertThat(root.get(i), equalTo(output.get(i)));
        }
    }
}
