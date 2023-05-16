package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 *      实现 MyStack 类：
 *          - void push(int x) 将元素 x 压入栈顶。
 *          - int pop() 移除并返回栈顶元素。
 *          - int top() 返回栈顶元素。
 *          - boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 *      注意：
 *          注意：
 *          你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 *          你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 思路：1、使用一个单向队列，在元素 x 入队的时候，将队列中 size-1 个元素 offer 到队列的尾部，此时队列里的元素顺序和栈相同，pop 和 top 操作与队列的 poll 和 peek 相同
 *      2、使用一个双向队列，略
 */
public class QueueRealizeStack {
    Queue<Integer> que;

    public QueueRealizeStack(){
        que = new LinkedList<>();
    }

    public void push(int x){
        que.offer(x);
        int size = que.size();
        size--;
        while (size-- > 0){
            que.offer(que.poll());
        }
    }

    public int pop(){
        return que.poll();
    }

    public int top(){
        return que.peek();
    }

    public boolean empty(){
        return que.isEmpty();
    }
}
