package StackAndQueue;

import java.util.Stack;

/**
 * 题目：请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *      实现 MyQueue 类：
 *          - void push(int x) 将元素 x 推到队列的末尾
 *          - int pop() 从队列的开头移除并返回元素
 *          - int peek() 返回队列开头的元素
 *          - boolean empty() 如果队列为空，返回 true ；否则，返回 false
 *      说明：
 *          你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 *          你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 <p>
 * 思路：使用两个栈，一个作为输入栈，一个作为输出栈，在 push 数据的时候，只要数据放进输入栈就好，
 *      但在 pop 的时候，输出栈如果为空，就把输入栈数据全部导入进来（注意是全部导入），再从输出栈弹出数据，如果输出栈不为空，则直接从输出栈弹出数据
 */
public class StackRealizeQueue {
    Stack<Integer> StackIn;
    Stack<Integer> StackOut;

    // Initialize data structure
    public StackRealizeQueue(){
        StackIn = new Stack<>();
        StackOut = new Stack<>();
    }

    // Push element x to the back of the queue
    public void push(int x){
        StackIn.push(x);
    }

    // Remove the element from the front of the queue and return it
    public int pop(){
        dumpStackIn();
        return StackOut.pop();
    }

    // Return the element at the front of the queue
    public int peek(){
        dumpStackIn();
        return StackOut.peek();
    }

    // Return true if the queue is empty, false otherwise
    public boolean isempty(){
        return StackIn.isEmpty() && StackOut.isEmpty();
    }

    // push the elements in the stackIn to the stackOut when the stackOut is empty
    private void dumpStackIn(){
        if (!StackOut.isEmpty()) return;
        while (!StackIn.isEmpty()){
            StackOut.push(StackIn.pop());
        }
    }
}
