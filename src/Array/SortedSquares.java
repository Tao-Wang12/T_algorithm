package Array;
import java.util.Arrays;
/*
* 题目：给你一个按非递减顺序排序的整数数组 nums，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
*/
public class SortedSquares {
    // 暴力解法：先求平方，再使用快速排序
    // 时间复杂度：O(n + nlog n)
    public static int[] function1(int[] nums){
        for (int i = 0; i < nums.length; i++){
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    // 双指针法：left指向左元素，right指向最右元素，新建一个和原数组相同大小的数组，指针k指向新数组的最右边，插入原数组中最大的值
    // 时间复杂度：O()
    public static int[] function2(int[] nums){
        int[] arr = new int[nums.length];
        int k = arr.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right){
            if (nums[right] * nums[right] >= nums[left] * nums[left]){
                arr[k--] = nums[right] * nums[right--];
            }else arr[k--] = nums[left] * nums[left++];
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {-2, -1, 0, 2, 4, 5};
        int[] nums1 = {-2, -1, 0, 2, 4, 5};
        System.out.println(Arrays.toString(function1(nums)));
        System.out.println(Arrays.toString(function2(nums1)));
    }
}
