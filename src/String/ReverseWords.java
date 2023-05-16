package String;

/**
 * 题目：给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 *      单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 *      返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 *      注意：输入字符串 s 中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 * <p>
 * 方法：分为三个步骤：
 *      1、移除字符串中的多余空格 -- 使用双指针法
 *      2、翻转整个字符串
 *      3、将每个单词逆序
 * <p>
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class ReverseWords {
    // 移除多余空格
    public StringBuilder removeExtraSpace(String s){
        int start = 0;
        int end = s.length()-1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end){
            char ch = s.charAt(start);
            if (ch != ' ' || sb.charAt(sb.length()-1) != ' '){
                sb.append(ch);
            }
            start++;
        }
        return sb;
    }

    // 反转整个字符串
    private void reverseString(StringBuilder sb, int start, int end){
        while (start < end){
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    // 反转每个单词
    private void reverseEachWord(StringBuilder sb){
        int start = 0;
        int end = 1;
        int len = sb.length();
        while (start < len){
            while (end < len && sb.charAt(end) != ' '){
                end++;
            }
            reverseString(sb, start, end-1);
            start = end+1;
            end = start+1;
        }
    }

    public String reverseWords(String s){
        StringBuilder sb = removeExtraSpace(s);
        reverseString(sb, 0, sb.length()-1);
        reverseEachWord(sb);

        return sb.toString();
    }
}