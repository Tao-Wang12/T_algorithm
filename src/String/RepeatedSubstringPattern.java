package String;

/**
 * 题目：给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
 * 思路：1、暴力
 *      2、判断其头去尾后的字符串s+s是否还包含字符串s
 *      3、使用KMP算法，如果一个字符串可以由一个字串构成，那么他的最长前后缀长度也就是next[s.length()-1]等于s.length()-字串长度
 *
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern3(String s){
        int len = s.length();
        if (len == 0) return false;
        int[] next = new int[len];
        getPrefix(next, s);
        return next[len - 1] != 0 && len % (len - next[len - 1]) == 0;
    }

    private void getPrefix(int[] next, String s){
        int j = 0;
        next[0] = j;
        for (int i = 1; i < s.length(); i++){
            while (j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j-1];
            }
            if (s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
    }

    // 可以直接判断 str 中去除首尾元素之后，是否包含自身元素。如果包含，则表明存在重复子串。
    public boolean repeatedSubstringPattern2(String s){
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}
