package easy;

// https://leetcode.com/problems/minimum-depth-of-binary-tree/

// Given a binary tree, find its minimum depth.
// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
// Note: A leaf is a node with no children.
//    Example 1:
//        Input: root = [3,9,20,null,null,15,7]
//        Output: 2
//    Example 2:
//        Input: root = [2,null,3,null,4,null,5,null,6]
//        Output: 5
//    Constraints:
//        The number of nodes in the tree is in the range [0, 10E5].
//        -1000 <= Node.val <= 1000

import org.junit.Test;

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

public class MinimumDepthofBinaryTree {
    public int minDepth2(TreeNode root) {
        if (root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> level = new Stack<>();
        TreeNode last = null;
        TreeNode node = root;
        int minDepth = -1;
        int depth = 0;

        // inorder traversal
        while(!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                node = node.left;
                depth++;
            } else {
                node = stack.peek();
                if (node.right == null || last == node.right) {
                    if (minDepth == -1 || (node.left == null && node.right == null && depth < minDepth))
                        minDepth = depth;

                    node = stack.pop();
                    last = node;
                    node = null;
                    depth --;
                } else {
                    node = node.right;
                }
            }
        }
        return minDepth;
    }

    // solution : Reculsive
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;

    }

    @Test
    public void test() {
        MinimumDepthofBinaryTree test = new MinimumDepthofBinaryTree();
        TreeNode root = null;

        root = new TreeNode(3,
                new TreeNode (9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7))
                            );
        assertThat(test.minDepth(root), equalTo(2));

        root = new TreeNode(2,
                null,
                new TreeNode(3,
                    null,
                    new TreeNode(4,
                            null,
                            new TreeNode(5,
                                    null,
                                    new TreeNode(6)
                                    )
                            )
                        )
                );
        assertThat(test.minDepth(root), equalTo(5));

        // [1,2,3,4,5]
        root = new TreeNode(1,
                    new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                    new TreeNode(3)
                );
        assertThat(test.minDepth(root), equalTo(2));
    }
}
