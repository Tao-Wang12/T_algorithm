package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 */
public class MinDepth {
    // 后序递归求最小高度
    public int minDepth1(BinaryTree root) {
        if (root == null) return 0;
        // 左子树为空，右子树不为空，则此时最小深度为右子树的最小深度
        if (root.left == null && root.right != null) {
            return 1 + minDepth1(root.right);
        }
        // 左子树不为空，右子树为空，则此时最小深度为左子树的最小深度
        if (root.left != null && root.right == null) {
            return 1 + minDepth1(root.left);
        }
        // 左右子树都不为空的情况，取左右子树最小深度的较小值
        return 1 + Math.min(minDepth1(root.left), minDepth1(root.right));
    }

    // 层序遍历，只有当左右子树都为空的时候，才是最小深度
    public int minDepth2(BinaryTree root) {
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
                if (node.left == null && node.right == null) return depth;
            }
        }
        return depth;
    }
}