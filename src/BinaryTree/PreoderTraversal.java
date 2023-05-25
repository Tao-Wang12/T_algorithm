package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import String.ReverseString.*;

/**
 * 二叉树前序遍历的 递归写法 与 迭代写法
 * <p>
 * 写递归算法的三个要素：
 * 1、确定递归函数的参数和返回值
 * 2、确定递归函数的终止条件
 * 3、确定单层递归的逻辑
 */
public class PreoderTraversal {
    private void preoder(BinaryTree cur, List<Integer> res) {
        if (cur == null) return;
        res.add(cur.val);
        preoder(cur.left, res);
        preoder(cur.right, res);
    }

    public List<Integer> preorderTraversal1(BinaryTree root) {
        List<Integer> res = new ArrayList<>();
        preoder(root, res);
        return res;
    }

    // 前序遍历: 中 左 右    入栈顺序：中 右 左
    public List<Integer> preorderTraversal2(BinaryTree root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<BinaryTree> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            BinaryTree temp = st.pop();
            res.add(temp.val);
            if (temp.right != null) {
                st.push(temp.right);
            }
            if (temp.left != null) {
                st.push(temp.left);
            }
        }
        return res;
    }
}
