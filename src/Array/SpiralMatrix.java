package Array;

import javax.naming.PartialResultException;
import java.util.Arrays;

/*
* 题目：给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
* 示例：输入3，输出 [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
* 方法：循环不变量原则
* 时间复杂度：O(n^2)
* 空间复杂度：O(1)
*/
public class SpiralMatrix {
    public static int[][] function(int n){
        int index = 0;
        int i, j = 0;
        int loop = 0;
        int count = 1;
        int[][] arr = new int[n][n];
        while (loop++ < n/2){
            for (j = index; j < n - loop; j++)
                arr[index][j] = count++;
            for (i = index; i < n - loop; i++)
                arr[i][j] = count++;
            for (; j > index; j--)
                arr[i][j] = count++;
            for (; i > index; i--)
                arr[i][j] = count++;
            index++;
        if (n/2 == 1)
            arr[index][index] = count;
        }
        return arr;
    }

    public static void main(String[] args) {
        int n = 4;
        function(n);
    }
}