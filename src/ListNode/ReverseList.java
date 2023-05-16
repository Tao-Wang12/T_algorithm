package ListNode;

/**
 * 题目：给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 方法：1、定义一个新链表来存放反转后的值 （舍）
 *      2、使用双指针直接反转链表
 */
public class ReverseList {
    // 使用双指针法
    public ListNode reverseList(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp; // 保存 cur 指针的下一节点
        while (cur != null){
            tmp = cur.next;
            cur.next = pre; // 反转指针方向
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}