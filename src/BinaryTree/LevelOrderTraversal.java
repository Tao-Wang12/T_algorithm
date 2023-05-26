package BinaryTree;

import java.util.*;

/**
 * 题目：层序遍历
 * 思路：用队列实现，使用 size 记录每层节点的个数，出队时对应地把将要出队节点的左右孩子入队
 */
public class LevelOrderTraversal {
    public List<List<Integer>> leverOrderTraversal(BinaryTree root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<BinaryTree> deque = new LinkedList<>();
        if (root != null) deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            int size = deque.size();
            while (size-- > 0) {
                BinaryTree node = deque.pop();
                temp.add(node.val);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            res.add(temp);
        }
        return res;
    }
}
