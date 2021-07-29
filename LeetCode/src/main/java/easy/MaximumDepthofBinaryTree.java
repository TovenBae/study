package easy;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.equalTo;

// https://leetcode.com/problems/maximum-depth-of-binary-tree/

// Given the root of a binary tree, return its maximum depth.
// A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
//
//    Example 1:
//        Input: root = [3,9,20,null,null,15,7]
//        Output: 3
//    Example 2:
//        Input: root = [1,null,2]
//        Output: 2
//    Example 3:
//        Input: root = []
//        Output: 0
//    Example 4:
//        Input: root = [0]
//        Output: 1
//
//    Constraints:
//        The number of nodes in the tree is in the range [0, 10E4].
//        -100 <= Node.val <= 100

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
public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int depth = 0;
        int maxDepth = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> level = new Stack<Integer>();
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                depth++;
                stack.push(root);
                level.push(depth);

                if (maxDepth < depth) {
                    maxDepth = depth;
                }
                root = root.left;
            }
            root = stack.pop();
            depth = level.pop();
            root = root.right;

        }

        return maxDepth;
    }

    // Solution : DFS
    public int maxDepth1(TreeNode root) {
        if(root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        stack.push(root);
        value.push(1);
        int max = 0;
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int temp = value.pop();
            max = Math.max(temp, max);
            if(node.left != null) {
                stack.push(node.left);
                value.push(temp+1);
            }
            if(node.right != null) {
                stack.push(node.right);
                value.push(temp+1);
            }
        }
        return max;
    }

    // solution : BFS
    public int maxDepth3(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
    }

    @Test
    public void test() {
        MaximumDepthofBinaryTree test = new MaximumDepthofBinaryTree();
        TreeNode root;
        TreeNode sub;
        int output;
        int result;

        root = new TreeNode(3);
        sub = new TreeNode(9);
        root.left = sub;
        sub = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        root.right = sub;
        result = test.maxDepth(root);
        output = 3;
        assertThat(result, equalTo(output));

        root = new TreeNode(1, null, new TreeNode(2));
        result = test.maxDepth(root);
        output = 2;
        assertThat(result, equalTo(output));

        root = null;
        result = test.maxDepth(root);
        output = 0;
        assertThat(result, equalTo(output));

        root = new TreeNode();
        result = test.maxDepth(root);
        output = 1;
        assertThat(result, equalTo(output));

        root = new TreeNode(1);
        sub = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        root.left = sub;
        sub = new TreeNode(3);
        root.right = sub;
        result = test.maxDepth(root);
        output = 3;
        assertThat(result, equalTo(output));

        sub = new TreeNode(6);
        sub = new TreeNode(5, null, sub);
        sub = new TreeNode(4, null, sub);
        sub = new TreeNode(3, null, sub);
        root = new TreeNode(2);
        root.right = sub;

        result = test.maxDepth(root);
        output = 5;
        assertThat(result, equalTo(output));

        // [0,2,4,1,null,3,-1,5,1,null,6,null,8]
        root = new TreeNode(0, new TreeNode(2), new TreeNode(4));
        sub = root.left;
        sub.left = new TreeNode(1, new TreeNode(5), new TreeNode(7));
        sub = root.right;
        sub.left = new TreeNode(3, null, new TreeNode(6));
        sub.right = new TreeNode(-1, null, new TreeNode(8));

        result = test.maxDepth(root);
        output = 4;
        assertThat(result, equalTo(output));

    }
}
