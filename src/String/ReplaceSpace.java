 package String;

/*
* 题目：请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
*      示例 1： 输入：s = "We are happy."
*      输出："We%20are%20happy."
* 方法：1、双指针法，首先将字符串长度扩充到目标长度(遍历到空格，长度加2)，设立两个指针，尾指针指向新长度下的末尾，头指针指向原长度下的末尾，从后往前遍历，遇到空格则将%20添加到字符串中；
*      2、使用一个新的对象复制String，复制的过程中对其判断，是空格则替换，否则直接复制
*/
public class ReplaceSpace {
    // 双指针法
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public String replacespace1(String s){
        if (s == null || s.length() == 0){
            return s;
        }
        // 扩充字符串长度
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                str.append("  ");
            }
        }
        // 判断是否有空格，没有则直接返回
        if (str.length() == 0){
            return s;
        }
        // 存在空格情况，定义两个指针分别指向两个新字符串的末尾
        int left = s.length()-1;
        s = s + str.toString();
        int right = s.length()-1;
        char[] result = s.toCharArray();
        while (left >= 0){
            if (result[left] == ' '){
                result[right--] = '0';
                result[right--] = '2';
                result[right] = '%';
            }else {
                result[right] = result[left];
            }
            right--;
            left--;
        }
        return new String(result);
    }

    // 定义一个新的对象复制原String
    public String replaceSpace2(String s){
        if (s == null || s.length() == 0)
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                sb.append("%20");
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    // 调用内置函数
    public String replaceSpace3(String s){
        String rs = s.replace(" ", "%20");
        return rs;
    }
}