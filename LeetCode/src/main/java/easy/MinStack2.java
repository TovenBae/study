package easy;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MinStack2 {
    Node stack;
    private class Node {
        int val;
        int min;
        Node next;
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    /** initialize your data structure here. */
    public MinStack2() {
        stack = null;
    }

    public void push(int val) {
        if (stack == null)
            stack = new Node(val, val, null);
        else
            stack = new Node(val, Math.min(val, stack.min), stack);
    }

    public void pop() {
        stack = stack.next;
    }

    public int top() {
        return stack.val;
    }

    public int getMin() {
        return stack.min;
    }

    @Test
    public void test() {
        E155_MinStack minStack = new E155_MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertThat(minStack.getMin(), equalTo(-3)); // return -3
        minStack.pop();
        assertThat(minStack.top(), equalTo(0));    // return 0
        assertThat(minStack.getMin(), equalTo(-2)); // return -2
        minStack.push(-5);
        minStack.push(1);
        assertThat(minStack.getMin(), equalTo(-5)); // return -2
        minStack.pop();
        assertThat(minStack.getMin(), equalTo(-5)); // return -2
        minStack.pop();
        assertThat(minStack.getMin(), equalTo(-2)); // return -2
    }
}
