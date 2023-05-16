package String;

/**
 * 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 *      比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 思路：1、不使用额外空间，类似于翻转单词那一题，先对前n个字符串进行反转，在对剩下的字符串进行反转，最后对整个字符串进行反转
 *      2、使用substring的方法，substring()有两种形式：substring(startIndex)，默认结束索引为最后一个字符串；substring(startIndex, endIndex)，左闭右开。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class ReverseLeftWords {
    public String reverseLeftWords1(String s, int n ){
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n-1);
        reverseString(sb, n, len-1);

        return sb.reverse().toString();
    }

    private void reverseString(StringBuilder sb, int start, int end){
        while (start < end){
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    public String reverseLeftWords2(String s, int n){
        // 相当于切片
        return s.substring(n) + s.substring(0, n); // 注意左闭右开
    }
}
