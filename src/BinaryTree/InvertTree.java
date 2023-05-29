package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeMap;

/**
 * 题目：给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 *
 */
public class InvertTree {
    // 前中后序遍历的递归实现
    public BinaryTree invertTree1(BinaryTree root) {
        if (root == null) return root;
        swap(root); // preorder
        invertTree1(root.left);
//        swap(root.left, root.right);
//        invertTree(root.left);     // inorder 注意：对左子树进行递归翻转后，原先的左子树到了右边，如果再对右子树递归翻转，则会重复操作得不到想要的翻转树
        invertTree1(root.right);
//        swap(root.left, root.right); // postorder
        return root;
    }

    public void swap(BinaryTree root) {
        BinaryTree temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    // 前中后序的迭代实现 -> 栈
    public BinaryTree invertTree2(BinaryTree root) {
        Stack<BinaryTree> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.isEmpty()) {
            BinaryTree node = st.peek();
            if (node != null) {
                st.pop();
                // preorder
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
                st.push(node);
                st.push(null);
                // inorder
//                if (node.right != null) st.push(node.right);
//                st.push(node);
//                st.push(null);
//                if (node.left != null) st.push(node.left);
                // postorder
//                st.push(node);
//                st.push(null);
//                if (node.right != null) st.push(node.right);
//                if (node.left != null) st.push(node.left);
            } else {
                st.pop();
                node = st.pop();
                swap(node);
            }
        }
        return root;
    }

    // 层次遍历 -> 队列
    public BinaryTree invertTree3(BinaryTree root) {
        if (root == null) return root;
        Deque<BinaryTree> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                BinaryTree node = deque.poll();
                swap(node);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return root;
    }
}
