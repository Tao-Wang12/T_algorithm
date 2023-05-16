package StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 题目：给定一个只包括 '('， ')'， '{'， '}'， '['， ']' 的字符串 s ，判断字符串是否有效。
 *      有效字符串需满足：
 *          左括号必须用相同类型的右括号闭合。
 *          左括号必须以正确的顺序闭合。
 *          每个右括号都有一个对应的相同类型的左括号。
 * ；思路：括号不匹配一共有三种情况：
 *          1、字符串左边的括号多余了
 *          2、字符串没有括号多余，但是不匹配
 *          3、字符串右边的括号多余了
 *        在匹配的过程中，可以判断第3和第2种情况；
 *        匹配完之后，可以判断第1种情况
 */
public class ParenthesesMatch {
    public boolean parenthesesMatch(String s){
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == '('){
                stack.push(')');
            }else if (ch == '{'){
                stack.push('}');
            }else if (ch == '['){
                stack.push(']');
            }else if (stack.isEmpty() || stack.peek() != ch){ // stack.isEmpty()说明字符串右边有多余的括号，stack.peek() != ch 说明字符串不匹配
                return false;
            }else {
                stack.pop();
            }
        }
        // 在遍历完字符串之后，如果deque不为空说明字符串左边有多余的字符串未消除
        return stack.isEmpty();
    }
}
