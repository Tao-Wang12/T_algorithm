package BinaryTree;

import java.util.*;

/**
 * 二叉树后序遍历的 递归实现 与 迭代实现
 */
public class PostorderTraversal {
    private void postorder(BinaryTree cur, List<Integer> res) {
        if (cur == null) return;
        postorder(cur.left, res);
        postorder(cur.right, res);
        res.add(cur.val);
    }

    public List<Integer> postorderTraversal1(BinaryTree root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    // 后序遍历：左 右 中   入栈顺序：中 左 右 后再翻转数组res
    public List<Integer> postorderTraversal2(BinaryTree root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<BinaryTree> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            BinaryTree temp = st.pop();
            res.add(temp.val);
            if (temp.left != null) {
                st.push(temp.left);
            }
            if (temp.right != null) {
                st.push(temp.right);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
