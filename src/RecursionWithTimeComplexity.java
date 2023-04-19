import java.util.Scanner;
/*
* 使用递归求x的n次方，并分析复杂度
* 递归算法的空间复杂度 = 每次递归的空间复杂度 * 递归的深度
* */

public class RecursionWithTimeComplexity{
    // 复杂度为O(n)的循环
    public static int function1(int x, int n){
        int res = 1;
        for (int i = 0; i < n; i++) {
            res = res * x;
        }
        return res;
    }

    // 使用递归，一共调用了n次递归，每次乘以时间复杂度为O(1)的乘法操作，所以复杂度其实是O(n)
    public static int function2(int x, int n){
        if (n == 0){
            return 1;
        }
        return function2(x, n-1) * x;
    }

    // 继续使用递归，时间复杂度仍然是O(n)
    public static int function3(int x, int n){
        if (n == 0) return 1;
        if (n == 1) return x;
        if (n % 2 == 1){
            return function3(x, n/2) * function3(x, n/2) * x;
        }
        return function3(x, n/2) * function3(x, n/2);
    }

    // 优化function3的方法，仅有一次递归调用，每次都是n/2，故时间复杂度是以log2为底n的对数次，即O(logn)
    public static int function4(int x, int n){
        if (n == 0) return 1;
        if (n == 1) return x;
        int tem = function4(x, n/2);
        if (n % 2 == 1){
            return tem * tem * x;
        }
        return tem * tem;
    }

    public static void main(String[] args) {
        System.out.println(function1(2, 5));
        System.out.println(function2(2, 5));
        System.out.println(function3(2, 5));
        System.out.println(function4(2, 5));
    }
}

//public class ListNode{
//    int val;
//    ListNode next;
//
//    public ListNode(){
//    }
//
//    public ListNode(int val){
//        this.val = val;
//    }
//
//    public ListNode(int val, ListNode next){
//        this.val = val;
//        this.next = next;
//    }
//}