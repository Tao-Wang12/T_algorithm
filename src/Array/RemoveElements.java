package Array;

/**
 * 问题：给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 *     不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
 *     元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElements {
    /**
     *  方法一：暴力解法 - 使用双循环 （注意点：数组边界问题）
     *  时间复杂度：0(n^2)
     *  空间复杂度：O(1)
     */
    public static int function1(int[] arr, int val){
        int size = arr.length;
        for (int i = 0; i < size; i++){
            if (arr[i] == val){
                for (int j = i+1; j < size; j++){
                    arr[j-1] = arr[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }

    /**
     * 方法二：快慢指针法
     *      - 快指针：寻找新数组的元素，新数组就是不含有目标元素的数组
     *      - 慢指针：指向更新后新数组下标的位置
     * 时间复杂度：0(n)
     * 空间复杂度：O(1)
     */
    public static int function2(int[] nums, int val){
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++){
            if (nums[fastIndex] != val){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    /**
     * 方法三：相向双指针法 - 基于元素顺序可以改变的题目，改变了元素相对位置，确保了移动最少元素
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int function3(int[] nums, int val){
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        while (rightIndex >= 0 && nums[rightIndex] == val) rightIndex--; //将右指针移到右边第一个不是val的位置
        while (leftIndex <= rightIndex){
            if (nums[leftIndex] == val){
                nums[leftIndex] = nums[rightIndex]; // 将最右边的元素移到（覆盖）左边等于val的位置
                rightIndex--;
            }
            leftIndex++;
            while (rightIndex >= 0 && nums[rightIndex] == val) rightIndex--;
        }
        return leftIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 1, 2, 5, 6, 3, 7, 3, 7, 3};
        int val = 3;
        System.out.println(function1(arr, val));
        System.out.println(function2(arr, val));
        System.out.println(function3(arr, val));
    }
}
