package easy;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MinStack3 {
    class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public MinStack3() {
        head = null;
    }

    public void push(int val) {
        if (head == null)
            head = new Node(val, val, null);
        else
            head = new Node(val, Math.min(val, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    @Test
    public void test() {
        MinStack3 minStack = new MinStack3();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        assertThat(minStack.getMin(), equalTo(-3)); // return -3
        minStack.pop();
        assertThat(minStack.top(), equalTo(0));    // return 0
        assertThat(minStack.getMin(), equalTo(-2)); // return -2
    }
}