package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 题目：给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *      返回 滑动窗口中的最大值。
 * 思路：自定义个一个单调队列（从大到小），有如下三个操作：
 *      1、pop() 弹出队列首部元素
 *      2、push() 加入新元素，在加入之前，比较队尾元素与新加入元素的大小，如果小于等于新元素则弹出，直至新元素小于等于栈尾元素
 *      3、maxValue() 在 1，2 步骤后，队首元素即为窗口最大值
 * 时间复杂度：O(n)
 * 空间复杂度：O(k) - 使用一个空间为 k 的数组存放结果
 */

//自定义单调队列及其三个基本操作

class MyQueue{
    Deque<Integer> deque = new LinkedList<>();

    void poll(int val){
        if (!deque.isEmpty() && val == deque.peek()){
            deque.removeFirst();
        }
    }

    void add(int val){
        while (!deque.isEmpty() && val > deque.getLast()){
            deque.removeLast(); // remove / removeFirst / pop / poll / pollFirst 都是删除队头
                                // removeLast / pollLast 是删除队尾
//            deque.pollLast();
        }
        deque.add(val);// add / addLast / offerLast / offer 都是添加到队尾
                        // push / addFirst / offerFirst 都是添加到队头
//        deque.addLast(val);
//        deque.offerLast(val);
//        deque.offer(val);
    }

    int maxValue(){
        return deque.peek();
    }
}
public class MaxSlidingWindows {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue myQueue = new MyQueue();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        // 先将前k个元素入队
        for (int i = 0; i < k; i++){
            myQueue.add(nums[i]);
        }
        res[index++] = myQueue.maxValue();
        // 处理剩下的元素，入队
        for (int j = k; j < nums.length; j++){
            // 判断是否移除最前面的元素
            myQueue.poll(nums[j-k]);
            // 判断是否加入新的元素
            myQueue.add(nums[j]);
            // 记录该窗口下的最大值
            res[index++] =  myQueue.maxValue();
        }

        return res;
    }
}

/**
 * add/remove源自集合，所以添加到队尾，从队头删除；
 * offer/poll源自队列（先进先出 => 尾进头出），所以添加到队尾，从队头删除；
 * push/pop源自栈（先进后出 => 头进头出），所以添加到队头，从队头删除；
 * offerFirst/offerLast/pollFirst/pollLast源自双端队列（两端都可以进也都可以出），根据字面意思，offerFirst添加到队头，offerLast添加到队尾，pollFirst从队头删除，pollLast从队尾删除。
 * <p>
 * 总结：
 * add/offer/offerLast添加队尾，三个方法等价；
 * push/offerFirst添加队头，两个方法等价。
 * remove/pop/poll/pollFirst删除队头，四个方法等价；
 * pollLast删除队尾。
 */