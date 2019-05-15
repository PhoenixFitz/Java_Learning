package stage.two.klaus;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    /**
     * 解法只用到了一个栈，还需要一个整型变量min_val来记录当前最小值，初始化为整型最大值，然后如果需要进栈的数字小于等于当前最小值min_val，
     * 那么将min_val压入栈，并且将min_val更新为当前数字。在出栈操作时，先将栈顶元素移出栈，再判断该元素是否和min_val相等，
     * 相等的话我们将min_val更新为新栈顶元素，再将新栈顶元素移出栈即可
     */

    private Stack<Integer> stack = new Stack<>();
    int min_val = Integer.MAX_VALUE;
    public MinStack(){

    }

    public void push(int x){
        if(x <= min_val){
            stack.push(min_val);
            min_val = x;
        }
        stack.push(x);
    }

    public void pop(){
        if(stack.pop() == min_val)
            min_val = stack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return min_val;
    }

}
