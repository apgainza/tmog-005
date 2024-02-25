package org.tfoc;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Stack;

/**
 * MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack()
 * obj.push(val)
 * obj.pop()
 * int param_3 = obj.top()
 * int param_4 = obj.getMin()
 */
public class MinStack {

    private Stack<Integer> data;
    private Stack<Integer> minData;

    public MinStack() {
        data = new Stack<>();
        minData = new Stack<>();
    }

    public void push(int val) {
        data.add(val);
        if (minData.isEmpty()) {
            minData.push(val);
        } else {
            Integer topMinData = minData.peek();
            if (Objects.nonNull(topMinData) && topMinData > val) {
                minData.push(val);
            }
        }
    }

    public void pop() {
        check();
        Integer removeTop = data.pop();
        if (removeTop.equals(minData.peek()))
            minData.pop();
    }

    public int top() {
        check();
        return data.peek();
    }

    public int getMin() {
        check();
        return minData.peek();
    }

    private void check() {
        if (data.isEmpty())
            throw new EmptyStackException();
    }

}
