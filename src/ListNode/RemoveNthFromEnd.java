package ListNode;

/**
 * 题目：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * 示例： 1 -> 2 -> 3 -> 4 -> null  (删除倒数第2个节点)
 *       1 -> 2 -> 4 -> null
 * 方法：使用两个指针 slow 和 fast，先让 fast 移动 n 步，再让两个指针同时移动，判断 fast.next 是否为空，为空时，此时 slow 指向被删除节点的前一节点。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slowNode = dummyNode;
        ListNode fastNode = dummyNode;
//        while (n-- >0)
        for (int i = 0; i < n; i++){
            fastNode = fastNode.next;
        }
        while (fastNode.next != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;
        return dummyNode.next;
    }
}
