package Array;

/*
* 题目：（长度最小的子数组）给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
* 解法1：使用暴力双循环，时间复杂度为O(n^2)
* 解法2：滑动窗口法，使用一个指针指向末尾，时间复杂度为O(2n)，也就是O(n)
*/
public class MinSubArrayLen {
    // 解法2
    public static int function2(int[] nums, int s){
        int res = Integer.MAX_VALUE;
        int sublen = 0; //滑动窗口的长度
        int i = 0; // 滑动窗口的起始位置
        int sum = 0; // 滑动窗口的总和
        for (int j = 0; j < nums.length; j++){ // j是滑动窗口的终点位置
            sum += nums[j];
            while (sum >= s){
                sublen = j - i + 1;
                res = Math.min(res, sublen);
                sum -= nums[i++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 5, 4, 3, 1};
        int s = 9;
        System.out.println(function2(nums, s));
    }
}
