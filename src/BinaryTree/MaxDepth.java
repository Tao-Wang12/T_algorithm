package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的<深度>为根节点到最远叶子节点的最长路径上的节点数。
 * 二叉树的<高度>为当前节点到叶子节点的最长路径上的节点数。
 */
public class MaxDepth {
    // 层序遍历法记录深度
    public int maxDepth1(BinaryTree root) {
        if (root == null) return 0;
        Deque<BinaryTree> deque = new LinkedList<>();
        int depth = 0;
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            while (size-- > 0) {
                BinaryTree node = deque.poll();
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return depth;
    }

    // 后序遍历递归求最大高度，也就是二叉树的最大深度
    public int maxDepth2(BinaryTree root) {
        if (root == null) return 0;
        int leftHeight = maxDepth2(root.left);
        int rightHeight = maxDepth2(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    // 前序遍历递归求最大深度
    int result = 0;
    public int maxDepth3(BinaryTree root) {
        getDepth(root, 0);
        return result;
    }

    public void getDepth(BinaryTree node, int depth) {
        if (node == null) return;
        depth++;
        result = result < depth ? depth : result;
        getDepth(node.left, depth);
        getDepth(node.right, depth);
        depth--;
    }
}
