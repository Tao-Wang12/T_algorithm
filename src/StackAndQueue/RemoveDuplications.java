package StackAndQueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 题目：给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *      在 S 上反复执行重复项删除操作，直到无法继续删除。
 *      在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 思路：1、使用栈或者队列，在使用栈时，最后对栈中元素输出后，是逆序；
 *      2、直接使用字符串处理，StringBuilder or StringBuffer
 *      3、使用双指针，每次遍历使用快指针覆盖慢指针，如果遇到相同的字符串，慢指针--，否则++，最后输出0 - slow 长度的字符串
 */
public class RemoveDuplications {
    public String removeDuplications1(String s){
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (!deque.isEmpty() && ch == deque.peek()){
                deque.pop();
                continue;
            }else {
                deque.push(ch);
            }
        }
        String str = "";
        while (!deque.isEmpty()){
            str = deque.pop() + str;
        }
        return str;
    }

    public String removeDuplications2(String s){
        StringBuilder sb = new StringBuilder();
        int top = -1;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (top >= 0 && ch == sb.charAt(top)){
                sb.deleteCharAt(top);
                top--;
            }else {
                sb.append(ch);
                top++;
            }
        }
        return sb.toString();
    }

    public String removeDuplications3(String s){
        int slow =0;
        int fast = 0;
        char[] ch = s.toCharArray();
        while (fast < s.length()){
            ch[slow] = ch[fast];
            if (slow > 0 && ch[slow] == ch[slow-1]){
                slow--;
            }else {
                slow++;
            }
            fast++;
        }
        return new String(ch, 0, slow);
    }
}
