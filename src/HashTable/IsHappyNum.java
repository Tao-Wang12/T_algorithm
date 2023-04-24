package HashTable;

import java.util.HashSet;
import java.util.Set;

/*
* 题目：编写一个算法来判断一个数 n 是不是快乐数。
*       「快乐数」定义为：
*               对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
*               然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
*               如果这个过程 结果为1，那么这个数就是快乐数。
*               如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
* 方法：1、使用集合存储每次各位数相加之和，比较集合中是否出现过此数之和，若有则说明陷入循环，返回false。若没有则返回结果是否为1的值。
*      2、使用快慢指针，快指针每次计算两次各位数之和，慢指针每次计算一次。若快慢指针值相等，则说明陷入循环，否则返回慢指针值是否为1的值。
*/
public class IsHappyNum {
    // 求该数的各位数之和
    public int bitSquareSum(int n){
        int sum = 0;
        while (n > 0){
            sum += (n%10) * (n%10);
            n /= 10;
        }
        return sum;
    }

    // 使用集合判断每次各位数之和是否出现在集合中，若有则说明陷入循环
    // 时间复杂度：O(log n)
    // 空间复杂度：O(log n)
    public boolean isHappyNum1(int n){
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)){
            record.add(n);
            n = bitSquareSum(n);
        }
        return n==1;
    }

    // 使用快慢指针法
    // 时间复杂度：O(log n)
    // 空间复杂度：O(1)
    public boolean isHappyNum2(int n){
        int slow = n;
        int fast = n;
        do {
            slow = bitSquareSum(slow);
            fast = bitSquareSum(bitSquareSum(fast));
        }while (fast != slow);
        return slow == 1;
    }
}
