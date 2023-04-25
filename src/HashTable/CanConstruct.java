package HashTable;

import java.util.Objects;

/*
* 题目：给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
*      如果可以，返回 true ；否则返回 false 。
*      magazine 中的每个字符只能在 ransomNote 中使用一次。
* 方法：1、暴力解法，双循环，magazine中若出现与ransomNote相同的字符，则删除ransomNote中的字符。最后判断ransomNote是否为空，是则返回true，不是则返回false。
*      2、使用数组记录magazine中各个字母出现的次数，再减去在ransomNote中各字母出现的次数，如果数组中出现负数，则说明不能返回false。
*/
public class CanConstruct {
    // 使用数组
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public boolean canconstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        if (magazine.length() < ransomNote.length())
            return false;
        for (char c : magazine.toCharArray()){
            record[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()){
            record[c - 'a']--;
        }
        for (int i : record){
            if (i < 0)
                return false;
        }
        return true;
    }
}
