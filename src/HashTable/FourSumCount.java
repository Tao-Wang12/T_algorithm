package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *      0 <= i, j, k, l < n, nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * 方法：使用 map 的 key 存放 nums1 和 nums2 的和，value 存放不同和出现的次数；
 *      在数组 nums3 和 nums4 中计算 0-(c+d) 的值，查询是否有对应的 key，存在则计数器加上对应的 value 值。
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(n)
 */
public class FourSumCount {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        Map<Integer, Integer> record = new HashMap<>();
        int count = 0;
        for (int a : nums1){
            for (int b : nums2){
                if (record.containsKey(a+b)){
                    record.put(a+b, record.get(a+b)+1);
                }else {
                    record.put(a+b, 1);
                }
            }
        }
        for (int c : nums3){
            for (int d : nums4){
                int temp = -(c + d);
                if (record.containsKey(temp)){
                    count += record.get(temp);
                }
            }
        }
        return count;
    }
}
