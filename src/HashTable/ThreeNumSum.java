package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 *      请你返回所有和为 0 且不重复的三元组。
 *      注意：答案中不可以包含重复的三元组。
 * 方法：1、哈希法，两层for循环，从数组中得到两数相加的值，再去比较set中是否有值等于c=0-(a+b)，有则输出此时的三个数，没有则将c的值加入set。
 *         时间复杂度：O(n^2)  空间复杂度：O(n)
 *      2、双指针法，首先对数组nums进行排序，然后有一层for循环，i从下标0开始，left指针指向i+1，right指针指向nums.length-1。接下来判断三数之和，如果大于0，则说明right对应的值大了
 *                right--。如果小于0，则说明left对应的值小了，left++。如果等于0，则将此三个数值记录到结果数组中。
 *                需要的注意的是，题目中要求不可以包含重复的三元组，故在实现的过程中需要注意去重操作！
 */
public class ThreeNumSum {
    // 双指针法
    // 时间复杂度：O(n^2)
    // 空间复杂度：O(1)
    public List<List<Integer>> threeSum(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++){
            // 剪枝
            if (nums[i] > 0)
                return result;
            // 去重nums[i]
            /**
             * 这种会忽略掉 -1，-1，2 的情况
             * if (nums[i] == nums[i+1])
             *     continue;
             */
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            int left = i+1;
            int right = nums.length-1;
            while (right > left){
                int sum = nums[i] + nums[left] + nums[right];
                // 如果在这里先对b、c去重的话，[0, 0, 0]这样的情况就会被忽略！
//                while (right > left && nums[right] == nums[right-1]) right--;
//                while (right > left && nums[left] == nums[left+1]) left++;
                if (sum > 0){
                    right--;
                }else if (sum < 0){
                    left++;
                }else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // 应该先找到一个符合条件的三元组之后，再对b、c去重
                    while (right > left && nums[right] == nums[right-1]) right--;
                    while (right > left && nums[left] == nums[left+1]) left++;
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
