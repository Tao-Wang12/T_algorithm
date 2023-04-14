package Array;

/*
* 题目：给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
* 解决方法：二分查找法 （两种区间法--1、[left, right]  2、[left, right) ）
* 时间复杂度：O(log n)
* 空间复杂度：O(1)
* */
public class BinarySearch {
    // 左闭右闭区间实现
    public static int function1(int[] arr, int target){
        if (target < arr[0] || target > arr[arr.length-1])
            return -1;
        int left = 0;
        int right = arr.length-1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > target)
                right = mid - 1;
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else return mid;
        }
        return -1;
    }

    // 左边右开区间实现
    public static int function2(int[] arr, int target){
        if (target < arr[0] || target > arr[arr.length-1])
            return -1;
        int left = 0;
        int right = arr.length;
        while (left < right){
            int mid = left + ((right - left) >> 1);
            if (arr[mid] > target){
                right = mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            }else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 8, 11, 23, 34};
        int target = 23;
        System.out.println(function1(arr, target));
        System.out.println(function2(arr, target));
    }
}
