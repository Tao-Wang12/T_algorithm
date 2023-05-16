package ListNode;

/**
 * 题目：给定一个链表的头节点 head，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *      如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *      如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 *      不允许修改链表!
 * 方法：使用快慢指针，快指针每次移动2步，慢指针每次移动1步。如果存在环，快慢指针一定会在环中某个节点相遇，并且慢指针未走完环的一圈。之后，重新定义两个指针，一个指向当前相遇的节点，
 *      另一个指向头节点，之后两个新节点各自一步一步的移动，直到相遇，此时相遇的节点即为环的入口节点。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head){
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (fastNode != null && fastNode.next != null){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode){
                ListNode index1 = fastNode;
                ListNode index2 = head;
                while (index1 != index2){
                    index2 = index2.next;
                    index1 = index1.next;
                }
                return index2;
            }
        }
        return null;
    }
}
