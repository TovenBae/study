package AugustLeetCodingChallenge2021.Week1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumS = new Stack<>();
        List<List<Integer>> lList = new ArrayList<>();
        TreeNode node = root;
        TreeNode last = new TreeNode();
        int sum = 0;
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
                    if (node.left == null && node.right == null && targetSum == sum) {
                        List<Integer> list = new ArrayList<>();
                        for (int i=0; i<stack.size(); i++) {
                            list.add(stack.get(i).val);
                        }
                        lList.add(list);
                    }
                    node = stack.pop();
                    sum = sumS.pop();
                    last = node;
                    node = null;

                } else {
                    node = node.right;
                }
            }
        }
        return lList;
    }

    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();

        List<List<Integer>> llist = new ArrayList<>();
        if (helper(root, targetSum, llist, new ArrayList<Integer>())) {
            return llist;
        } else {
            return new ArrayList<>();
        }
    }

    public boolean helper(TreeNode root, int targetSum, List<List<Integer>> llist, List<Integer> list) {
        if (root == null) return false;

        if (root.left == null && root.right == null && targetSum == root.val) {
            list.add(root.val);
            llist.add(list);
            return true;
        }

        if (helper(root.left, targetSum - root.val, llist, list)) {
            list.add(root.val);
            return true;
        }
        if (helper(root.right, targetSum - root.val, llist, list)) {
            list.add(root.val);
            return true;
        }
        return false;
    }

    @Test
    public void test() {
        PathSumII test = new PathSumII();
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
        assertThat(test.pathSum(root, 22), equalTo(null));

    }
}