package easy;

//https://leetcode.com/problems/balanced-binary-tree/

//    Given a binary tree, determine if it is height-balanced.
//    For this problem, a height-balanced binary tree is defined as:
//        a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
//
//    Example 1:
//        Input: root = [3,9,20,null,null,15,7]
//        Output: true
//    Example 2:
//        Input: root = [1,2,2,3,3,null,null,4,4]
//        Output: false
//    Example 3:
//        Input: root = []
//        Output: true
//
//    Constraints:
//        The number of nodes in the tree is in the range [0, 5000].
//        -10E4 <= Node.val <= 10E4

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
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
public class E110_BalancedBinaryTree {
    public boolean isBalanced4(TreeNode root) {
        if (root == null)
            return true;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while(root != null) {
                int diff = maxDepth(root.left) - maxDepth(root.right);
                if (diff < -1 || diff > 1)
                    return false;

                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;

        }
        return true;
    }

    public int maxDepth(TreeNode tn) {
        if (tn == null)
            return 0;

        int maxDepth = 0;
        int depth = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> level = new Stack<Integer>();
        while(tn != null || !stack.isEmpty()) {
            while(tn != null) {
                depth++;
                stack.push(tn);
                level.push(depth);
                tn = tn.left;
                if (depth > maxDepth)
                    maxDepth = depth;
            }
            tn = stack.pop();
            depth = level.pop();
            tn = tn.right;
        }
        return maxDepth;
    }

    private boolean result = true;

    // Solution #1
    public boolean isBalanced1(TreeNode root) {
        maxDepth2(root);
        return result;
    }

    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        int l = maxDepth2(root.left);
        int r = maxDepth2(root.right);
        if (Math.abs(l - r) > 1)
            result = false;
        return 1 + Math.max(l, r);
    }

    // Solution #2
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Map<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if((node.left==null || node.left!=null && map.containsKey(node.left)) &&
                    (node.right==null || node.right!=null && map.containsKey(node.right))){
                int left = node.left==null?0:map.get(node.left);
                int right = node.right==null?0:map.get(node.right);
                if(Math.abs(left-right) > 1) return false;
                map.put(node, Math.max(left, right)+1);
            }else{
                if(node.left!=null && !map.containsKey(node.left)){
                    stack.push(node);
                    stack.push(node.left);
                }else{
                    stack.push(node);
                    stack.push(node.right);
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        E110_BalancedBinaryTree test = new E110_BalancedBinaryTree();
        TreeNode root = null;
        TreeNode left = null;
        TreeNode right = null;

        root = new TreeNode(3, new TreeNode(9), null);
        left = new TreeNode(20, new TreeNode(4), new TreeNode(4));
        root.right = left;
        assertThat(test.isBalanced((root)), equalTo(true));

        root = new TreeNode(1);
        root.left = new TreeNode(2);
        left = root.left;
        left.left = new TreeNode(3, new TreeNode(4), new TreeNode(4));
        root.right = new TreeNode(2);
        assertThat(test.isBalanced(root), equalTo(false));

        root = null;
        assertThat(test.isBalanced(root), equalTo(true));

        // [1,2,2,3,null,null,3,4,null,null,4]
        //            1
        //      2          2
        //   3                  3
        // 4                      4
        root = new TreeNode(1,
                    new TreeNode(2,
                            new TreeNode(3,
                                    new TreeNode(4), null),
                                    null),
                    new TreeNode(2,
                                    null,
                            new TreeNode(3,
                                            null, new TreeNode(4))));

        assertThat(test.isBalanced(root), equalTo(false));
    }
}
