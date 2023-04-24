package HashTable;

import java.util.HashMap;
import java.util.Map;

/*
* 题目：给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标。
*      你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。你可以按任意顺序返回答案。
* 方法：由于需要去数组中查找两个数并且要返回他们对应的下标，选择 map 作为哈希表，对整个数组遍历，判断所需值是否在 map 中，存在则输出对应的下标，不存在则将当前遍历元素及下标存入 map 中。
*      直到遍历完整个数组，返回结果数组。（这里注意 map(key， value) key对应存放的是数组的元素，value存放的是元素的下标）
* 时间复杂度：O(n)
* 空间复杂度：O(n)
*/
public class TwoNumSum {
    public int[] twoNumSum(int[] num, int target){
        int[] res = new int[2];
        if (num == null || num.length == 0)
            return res;
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < num.length; i++){
            int temp = target - num[i];
            if (record.containsKey(temp)){
                res[0] = i;
                res[1] = record.get(temp);
                break;
            }
            record.put(num[i], i);
        }
        return res;
    }
}
