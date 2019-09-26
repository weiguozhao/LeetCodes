package javalanguage.easy;

import java.util.Stack;

/**
 * @author zhaoweiguo
 * @date 2019-09-25
 */
public class MinStack {
    /**
     * problem 155
     * https://leetcode-cn.com/problems/min-stack/
     */
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty() || stack2.peek() > x) {
            stack2.push(x);
        } else {
            //当前peek仍是最小值
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        if (!stack1.isEmpty()) {
            stack1.pop();
            stack2.pop();
        }
    }

    public int top() {
        if (stack1.isEmpty()) {
            throw new RuntimeException("MinStack is Empty!");
        }
        return stack1.peek();
    }

    public int getMin() {
        if (stack2.isEmpty()) {
            throw new RuntimeException("MinStack is Empty!");
        }
        return stack2.peek();
    }

    /**
     * 思路：
     * 辅助栈不需要保存原始的数据，只要保存当前最小的值即可
     * */

    public static void main(String[] args) {
        int res;

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        //--> 返回 -3.
        res = minStack.getMin();
        System.out.println(res);

        minStack.pop();

        //--> 返回 0.
        res = minStack.top();
        System.out.println(res);

        //--> 返回 -2.
        res = minStack.getMin();
        System.out.println(res);
    }
}
