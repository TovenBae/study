package easy;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.equalTo;

//https://leetcode.com/problems/symmetric-tree/

//Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
//
//    Example 1:
//        Input: root = [1,2,2,3,4,4,3]
//        Output: true
//    Example 2:
//        Input: root = [1,2,2,null,3,null,3]
//        Output: false
//
//    Constraints:
//        The number of nodes in the tree is in the range [1, 1000].
//        -100 <= Node.val <= 100
//
//        Follow up: Could you solve it both recursively and iteratively?
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
public class E101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // Iterating method 방식 사용 구현
        TreeNode n1 = root.left;
        TreeNode n2 = root.right;
        Stack<TreeNode> st1 = new Stack<TreeNode>();
        Stack<TreeNode> st2 = new Stack<TreeNode>();
        while(n1 != null || n2 != null || !st1.isEmpty() || !st2.isEmpty()) {
            while(n1 != null || n2 != null) {
                if (n1 == null && n2 == null)
                    ;
                else if (n1 == null || n2 == null)
                    return false;

                if (n1.val != n2.val)
                    return false;
                st1.push(n1);
                st2.push(n2);
                n1 = n1.left;
                n2 = n2.right;

            }
            n1 = st1.pop();
            n2 = st2.pop();
            n1 = n1.right;
            n2 = n2.left;
        }

        return true;
    }

    @Test
    public void test() {
        boolean isTrue, output;
        TreeNode root;
        TreeNode sub;
        E101_SymmetricTree test = new E101_SymmetricTree();

        root = new TreeNode(1);
        sub = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.left = sub;
        sub = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        root.right = sub;
        output = true;
        isTrue = test.isSymmetric(root);
        assertThat(isTrue, equalTo(output));

        root = new TreeNode(1);
        sub = new TreeNode(2, null, new TreeNode(3));
        root.left = sub;
        sub = new TreeNode(2, null, new TreeNode(3));
        root.right = sub;
        output = false;
        isTrue = test.isSymmetric(root);
        assertThat(isTrue, equalTo(output));

        root = new TreeNode(1);
        sub = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.left = sub;
        sub = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = sub;
        output = false;
        isTrue = test.isSymmetric(root);
        assertThat(isTrue, equalTo(output));

        root = new TreeNode(1);
        sub = new TreeNode(2, null, new TreeNode(4));
        root.left = sub;
        sub = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        root.right = sub;
        output = false;
        isTrue = test.isSymmetric(root);
        assertThat(isTrue, equalTo(output));

        root = new TreeNode(1);
        sub = new TreeNode(0);
        root.left = sub;
        output = false;
        isTrue = test.isSymmetric(root);
        assertThat(isTrue, equalTo(output));

        root = new TreeNode(2);
        sub = new TreeNode(3, new TreeNode(4), new TreeNode(5));
        root.left = sub;
        sub = new TreeNode(3, null, new TreeNode(4));
        root.right = sub;
        output = false;
        isTrue = test.isSymmetric(root);
        assertThat(isTrue, equalTo(output));

    }
}
