package String;

public class ReverseString {
/*
* 题目1：编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
*      不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
*
* 方法：双指针分别指向头尾，调换头尾指针的字符串
*
* 时间复杂度：O(n)
* 空间复杂度：O(1)
*/
    public void reverseString(char[] s){
        int len = s.length;
        for (int i = 0; i < len/2; i++){
            char temp;
            temp = s[i];
            s[i] = s[len-1-i];
            s[len-1-i] = temp;
        }
    }

/*
* 题目2：给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
*       * 如果剩余字符少于 k 个，则将剩余字符全部反转。
*       * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
*
* 方法：与题目1类似，循环时i每次的增量是2k而不是1，最后一组2k需要判断剩余字符数。
*
* 时间复杂度：O(n)
* 空间复杂度：O(1)
*/
    public String reverseStr1(String s, int k){
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i+=2*k){
            // 剩余字符小于 2k 但大于或等于 k 个
            if ((i+k) <= ch.length){
                reverse(ch, i, i+k-1);
                continue;
            }
            // 剩余字符少于 k 个
            reverse(ch, i, ch.length-1);
        }
        return new String(ch);

    }

    public void reverse(char[] s, int left, int right){
        for (; left < right; left++, right--){
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
        }
    }

    // 另一种写法
    public String reverseStr2(String s, int k){
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i+=2*k){
            int left = i;
            // 判断最后一组字符串
            int right = Math.min(ch.length-1, left+k-1);
            while (left < right){
                char temp = ch[right];
                ch[right] = ch[left];
                ch[left] = temp;
                left++;
                right--;
            }
        }
        return new String(ch);
    }
}
