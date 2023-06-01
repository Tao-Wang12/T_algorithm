package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class IsSymmetric {
    public boolean compare(BinaryTree left, BinaryTree right) {
        // 排除左右存在空节点的情况
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        // 排除左右无空节点但值不等的情况
        if (left.val != right.val) return false;
        // 此时是左右不空且值相等的情况，以下再做下一层的判断
        boolean outside = compare(left.left, right.right); // 外侧
        boolean inside = compare(left.right, right.left);  // 内侧
        return outside && inside;
    }
    // 递归法
    public boolean isSymmetric1(BinaryTree root) {
        if (root == null) return false;
        return compare(root.left, root.right);
    }

    // 迭代法
    public boolean isSymmetric2(BinaryTree root) {
        if (root == null) return false;
        Deque<BinaryTree> deque = new ArrayDeque<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            BinaryTree leftNode = deque.pop();
            BinaryTree rightNode = deque.pop();
            // 左右都为空，说明是对称的
            if (leftNode == null && rightNode == null) {
                continue;
            }
            // 三种不对称的情况：左空右不空，左不空有空，左右都不空但值不等
            if (leftNode == null && rightNode != null) {
                return false;
            }
            if (leftNode != null && rightNode == null) {
                return false;
            }
            if (leftNode.val != rightNode.val) {
                return false;
            }
            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        return true;
    }
}
