package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目：给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 *      使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 方法：与三数之和题目类似，也使用双指针，只不过三数之和只用单层循环，这里需要双层循环。
 *      a，b，c，d分别对应nums[i], nums[j], nums[left], nums[right]
 * 时间复杂度：O(n^3)
 * 空间复杂度：O(1)
 */
public class FourNumSum {
    public List<List<Integer>> fourNumSum(int[] nums, int target){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++){
            // 对 a 去重
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < nums.length; j++){
                // 对 b 去重
                if (j > i+1 && nums[j] == nums[j-1])
                    continue;
                int left = j+1;
                int right = nums.length-1;
                while (left < right){
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right]; // 防止int类型溢出
                    if (sum > target){
                        right--;
                    } else if (sum < target) {
                        left++;
                    }else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 对 c d 去重
                        while (left < right && nums[right] == nums[right-1]) right--;
                        while (left < right && nums[left] == nums[left+1]) left++;
                        right--;
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
