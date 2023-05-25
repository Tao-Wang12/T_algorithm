package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树中序遍历的 递归实现 与 迭代实现
 */
public class InorderTraversal {
    private void inorder(BinaryTree cur, List<Integer> res) {
        if (cur == null) return;
        inorder(cur.left, res);
        res.add(cur.val);
        inorder(cur.right, res);
    }

    public List<Integer> inorderTraversal1(BinaryTree root) {
        List<Integer> res = new ArrayList<>();
        inorder(root, res);
        return res;
    }

    public List<Integer> inorderTraversal2(BinaryTree root) {
        List<Integer> res = new ArrayList<>();
        Stack<BinaryTree> st = new Stack<>();
        BinaryTree cur = root;
        while (cur != null || !st.isEmpty()) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }
}
