package StackAndQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 题目：给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * 思路：该题主要完成三个步骤：
 *                      1、统计数组 nums 中各个元素出现的频率   -  map
 *                      2、对频率进行排序   - 小顶堆(优先级队列)，可以只维护 k 个元素
 *                      3、取 k 个频率高所对应的元素
 * 时间复杂度：O(n logk)
 * 空间复杂度：O(n)
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        // 统计数组 nums 中各元素出现的频率
        for (int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        // 使用 PriorityQueue 存储二元组map(key， value)
        // 按 value 大小从小到大排序，value 越小的 key 放在 pq 的头部
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[1]-pair2[1]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (pq.size() < k){
                pq.add(new int[]{entry.getKey(), entry.getValue()});
            }else {
                if (entry.getValue() > pq.peek()[1]){
                    pq.poll();
                    pq.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }

        int[] res = new int[k];
        for (int i = k-1; i >= 0; i--){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
