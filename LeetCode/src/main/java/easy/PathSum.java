package easy;

//https://leetcode.com/problems/path-sum/

/**
Given the root of a binary tree and an integer targetSum,
return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
A leaf is a node with no children.

    Example 1:
        Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        Output: true
    Example 2:
        Input: root = [1,2,3], targetSum = 5
        Output: false
    Example 3:
        Input: root = [1,2], targetSum = 0
        Output: false

    Constraints:
        The number of nodes in the tree is in the range [0, 5000].
        -1000 <= Node.val <= 1000
        -1000 <= targetSum <= 1000
*/

import org.junit.Test;

import java.util.ArrayList;
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
public class PathSum {
    // use iteration
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumS = new Stack<>();
        TreeNode node = root;
        TreeNode last = new TreeNode();
        int sum = 0;

        // inoder traversal
        while(!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.push(node);
                sum += node.val;
                sumS.push(sum);
                node = node.left;
            } else {
                node = stack.peek();
                sum = sumS.peek();
                if (node.right == null || last == node.right) {
                    if (node.left == null && node.right == null && sum == targetSum)
                        return true;
                    node = stack.pop();
                    sum = sumS.pop();
                    last = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }

        return false;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null && root.val == targetSum)
            return true;
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum- root.val);
    }

    @Test
    public void test() {
        PathSum test = new PathSum();
        TreeNode root;

        // root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
        root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                null,
                                new TreeNode(1)))
        );
        assertThat(test.hasPathSum(root, 22), equalTo(true));

        root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        assertThat(test.hasPathSum(root, 5), equalTo(false));

        root = new TreeNode(1, new TreeNode(2), null);
        assertThat(test.hasPathSum(root, 0), equalTo(false));
        assertThat(test.hasPathSum(root, 1), equalTo(false));

    }
}
