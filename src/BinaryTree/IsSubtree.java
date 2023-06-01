package BinaryTree;

/**
 * 题目：给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 *      二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 * 思路：一棵树是另一棵树的子树，只有三种情况：
 *      1、两棵树相同 (Leecode 100)
 *      2、subRoot 是 root 左子树的子树
 *      3、subRoot 是 root 右子树的子树
 */
public class IsSubtree {
    public boolean isSame(BinaryTree root, BinaryTree subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        return isSame(root.left, subRoot.left) && isSame(root.right, subRoot.right);
    }

    public boolean isSubtree(BinaryTree root, BinaryTree subRoot) {
        if (root == null) return false;
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
}
