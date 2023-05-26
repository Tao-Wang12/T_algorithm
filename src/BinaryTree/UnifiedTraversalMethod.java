package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 前、中、后序遍历的统一迭代方法
 * 思路：将访问的节点放入栈中，同时将要处理的节点也放入栈中但要紧接着放入一个空指针NULL
 */
public class UnifiedTraversalMethod {
    // 前序遍历
    public List<Integer> preorder(BinaryTree root) {
        List<Integer> res = new ArrayList<>();
        Stack<BinaryTree> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.isEmpty()) {
            BinaryTree node = st.peek();
            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right); // 右
                if (node.left != null) st.push(node.left);   // 左
                st.push(node);                               // 中
                st.push(null);
            } else {
                st.pop();
                node = st.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    // 中序遍历
    public List<Integer> inorder(BinaryTree root) {
        List<Integer> res = new ArrayList<>();
        Stack<BinaryTree> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.isEmpty()) {
            BinaryTree node = st.peek();
            if (node != null) {
                st.pop();
                if (node.right != null) st.push(node.right); // 右
                st.push(node);                               // 中
                st.push(null);
                if (node.left != null) st.push(node.left);   // 左
            } else {
                st.pop();
                node = st.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    // 后序遍历
    public List<Integer> postorder(BinaryTree root) {
        List<Integer> res = new ArrayList<>();
        Stack<BinaryTree> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.isEmpty()) {
            BinaryTree node = st.peek();
            if (node != null) {
                st.pop();
                st.push(node);                               // 中
                st.push(null);
                if (node.right != null) st.push(node.right); // 右
                if (node.left != null) st.push(node.left);   // 左
            } else {
                st.pop();
                node = st.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}
