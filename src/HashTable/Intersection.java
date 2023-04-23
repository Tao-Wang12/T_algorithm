package HashTable;

import java.util.HashSet;
import java.util.Set;

/*
* 题目：给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以不考虑输出结果的顺序。
* 方法：数组大小不定，且结果无序、无重复数据，故使用set。首先将数组nums1加入集合，再将数组nums2逐一与集合比较，存在相同值则将该数据加入结果集合，最后将集合转换为数组输出。
* 时间复杂度：O(n)
* 空间复杂度：O(1)
*/
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2){
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return new int[0];
        Set<Integer> set = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums1)
            set.add(i);
        for (int i : nums2){
            if (set.contains(i))
                resultSet.add(i);
        }
        // 方法1：将ResultSet转为数组
        return resultSet.stream().mapToInt(x -> x).toArray();
        // 方法2：另外申请一个数组存放resultSet中的元素,最后返回数组
//        int[] resArray = new int[resultSet.size()];
//        int j = 0;
//        for (int i : resultSet)
//            resArray[j++] = i;
//        return resArray;
    }
}