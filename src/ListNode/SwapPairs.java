package ListNode;

/*
* 题目：给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
* 示例：  1 -> 2 -> 3 -> 4
*        2 -> 1 -> 4 -> 3
* 时间复杂度：O(n)
* 空间复杂度：O(1)
*/
public class SwapPairs {
    public ListNode swapPairs(ListNode head){
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null){
            ListNode temp1 = cur.next;
            ListNode temp2 = cur.next.next.next;
            cur.next = cur.next.next;
            cur.next.next = temp1;
            temp1.next = temp2;
            cur = cur.next.next;
        }
        return dummyNode.next;
    }
}
