package AugustLeetCodingChallenge2021.Week1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    List<List<Integer>> llist = new ArrayList<>();
    public List<List<Integer>> pathSum2(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();

        helper(root, targetSum, new ArrayList<Integer>());

        return llist;
    }

    public void helper(TreeNode root, int targetSum, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);

        if (root.left == null && root.right == null && targetSum == root.val) {
            llist.add(new ArrayList<>(list));
        }

        helper(root.left, targetSum - root.val, list);

        helper(root.right, targetSum - root.val, list);

        list.remove(list.size() -1);
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
                        new TreeNode(4),
                        new TreeNode(7,
                                null,
                                new TreeNode(2)))
        );
        List<List<Integer>> output = Arrays.asList(
                Arrays.asList(5, 4, 11, 2),
                Arrays.asList(5, 8, 7, 2));
        assertThat(test.pathSum(root, 22), equalTo(output));
        assertThat(test.pathSum2(root, 22), equalTo(output));

    }
}