package String;

/*
* 题目：给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
*      如果 needle 不是 haystack 的一部分，则返回 -1 。
*
* 时间复杂度：O(m+n)
* 空间复杂度：O(1)
*/
public class StrStr {
    public int strStr1(String haystack, String needle){
        if (needle.length() == 0)
            return 0;
        int[] next = new int[needle.length()];
        getPrefix(next, needle);
        int j = 0; // j 指向 needle 字符串的首个字符
        for (int i = 0; i < haystack.length(); i++){ // i 指向 haystack 字符串的首个字符
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if (j == needle.length()){ // 注意此时判断的是 j 的位置到达 needl 字符串的末尾的后一个字符
                return i-needle.length()+1;
            }
        }
        return -1;
    }

    // 获得模式串的前缀表，用next数组存储
    private void getPrefix(int[] next, String s){
        // 初始化
        int j = 0;
        next[0] = j;
        for (int i = 1; i < s.length(); i++){
            // 判断字符不相等的情况
            while (j > 0 && s.charAt(j) != s.charAt(i)){
                j = next[j-1];
            }
            // 判断字符串相等的情况
            if (s.charAt(j) == s.charAt(i)){
                j++;
            }
            next[i] = j;
        }
    }

    // 使用内置函数indexOf
    /*
     * 1、 public int indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
       2、 public int indexOf(int ch, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
       3、 int indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
       4、 int indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
     */
    public int strStr2(String haystack, String needle){
        return haystack.indexOf(needle);
    }
}
