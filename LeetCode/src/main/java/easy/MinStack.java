package easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * https://leetcode.com/problems/min-stack/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * *
 * Example 1:
 *      Input
 *          ["MinStack","push","push","push","getMin","pop","top","getMin"]
 *          [[],[-2],[0],[-3],[],[],[],[]]
 *      Output
 *          [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 *      MinStack minStack = new MinStack();
 *      minStack.push(-2);
 *      minStack.push(0);
 *      minStack.push(-3);
 *      minStack.getMin(); // return -3
 *      minStack.pop();
 *      minStack.top();    // return 0
 *      minStack.getMin(); // return -2
 *
 * Constraints:
 *      -2E31 <= val <= 2E31 - 1
 *
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */

public class MinStack {
    List<int []> stack = new ArrayList<>();
    int minVal = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int val) {
        minVal = Math.min(minVal, val);
        stack.add(new int[]{val, minVal});
    }

    public void pop() {
        stack.remove(stack.size()-1);
    }

    public int top() {
        return stack.get(stack.size()-1)[0];
    }

    public int getMin() {
        return stack.get(stack.size()-1)[1];
    }

    @Test
    public void test() {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertThat(minStack.getMin(), equalTo(-3)); // return -3
        minStack.pop();
        assertThat(minStack.top(), equalTo(0));    // return 0
        assertThat(minStack.getMin(), equalTo(-2)); // return -2
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */