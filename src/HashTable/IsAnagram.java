package HashTable;

/*
* 题目：给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。注意：若s 和 t中每个字符出现的次数都相同，则称s 和 t互为字母异位词。
* 方法：使用数组充当哈希表，建立一个长度为26小写字母大小的数组，首先将字符串s中各个字母出现的次数加到对应下表的位置，然后将字符串t中各个字母出现的次数减去到对应的下标的位置，
*      最后判断该数组的值是否都是0。若存在不为0的数组值，则返回false，都为0则返回true。
* 时间复杂度：O(n)
* 空间复杂度：O(1)
*/
public class IsAnagram {
    public boolean isAnagram(String s, String t){
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++)
            record[s.charAt(i) - 'a']++; // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以
        for (int j = 0; j < t.length(); j++)
            record[t.charAt(j) - 'a']--;
        for (int count : record){
            if (count != 0)
                return false;
        }
        return true;
    }
}
