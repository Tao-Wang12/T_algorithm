package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目1：给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * 示例：输入3，输出 [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 方法：循环不变量原则
 * 时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * <p>
 * 题目2：给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 方法：与题目1类似
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
public class SpiralMatrix {
    public static int[][] function1(int n){
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

    // 还是有点问题，不能满足所有情况
    public static List<Integer> function2(int[][] matrix){
        List<Integer> list = new ArrayList<Integer>();
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数
        if (m == 1){
            for(int i = 0; i < n; i++)
                list.add(matrix[i][0]);
        }
        if (n == 1){
            for (int j = 0; j < m; j++)
                list.add(matrix[0][j]);
        }
        int loop = Math.min(m, n) / 2; // 循环的圈数
        int x = 0, y = 0, i = 0, j = 0;
        int offset = 1;
        while (loop-- > 0){
            for (j = x; j < n - offset; j++)
                list.add(matrix[x][j]);
            for (i = y; i < m - offset; i++)
                list.add(matrix[i][j]);
            for (; j > y; j--)
                list.add(matrix[i][j]);
            for (; i > x; i--)
                list.add(matrix[i][j]);
            x++;
            y++;
            offset++;
        }
        if ((Math.min(m, n) / 2) % 2 == 1){
            if (m > n){
                for (i = y; i <= m - offset; i++)
                    list.add(matrix[i][y]);
            }else if (m < n){
                for (j = x; j <= n - offset; j++)
                    list.add(matrix[x][j]);
            }else list.add(matrix[x][x]);
        }
        return list;
    }

    // 左闭右闭法，最容易实现
    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int up = 0, down = m-1, left = 0, right = n-1; // 控制上下左右边界
        List<Integer> list = new ArrayList<Integer>();
        while(true){
            for(int i = left; i <= right; i++)
                list.add(matrix[left][i]);
            if(++up > down) break;

            for(int i = up; i <= down; i++)
                list.add(matrix[i][right]);
            if(--right < left) break;

            for(int i = right; i >= left; i--)
                list.add(matrix[down][i]);
            if(--down < up) break;

            for(int i = down; i >= up; i--)
                list.add(matrix[i][left]);
            if(++left > right) break;
        }
        return list;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix1 = {{1}};
        System.out.println(Arrays.deepToString(function1(n)));
        System.out.println((function2(matrix1))); // 错误
        System.out.println((function2(matrix)));
        System.out.println(spiralOrder(matrix1));
    }
}