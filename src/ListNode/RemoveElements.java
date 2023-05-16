package ListNode;

/**
 * 题目：给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回新的头节点。
 * 方法：1、原链表上操作  2、设置一个虚拟头节点
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(){
    }
    ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}

public class RemoveElements {
    // 方法1：在原链表上操作
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public ListNode function1(ListNode head, int val){
        // 处理头节点 = val 的情况 （这里要先处理头节点是否等于val的情况，防止用例 [1, 1, 1]，去除1的情况）
        while (head != null && head.val == val){
            head = head.next;
        }
        // 空链表，则返回空
        if (head == null)
            return head;
        // 处理其他节点 = val 的情况
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    // 方法2：设置一个虚拟头节点
    // 时间复杂度：O(n)
    // 空间复杂度：O(1)
    public ListNode function2(ListNode head, int val){
        // 处理空链表
        if (head == null)
            return head;
        // 其他情况
        ListNode dummyNode = new ListNode(-1, head);
        ListNode pre = dummyNode;
        ListNode cur = head;
        while (cur != null){
            if (cur.val == val){
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummyNode.next;
    }
}