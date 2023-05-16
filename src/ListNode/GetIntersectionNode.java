package ListNode;

/**
 * 题目：给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
 * 时间复杂度：O(m + n)
 * 空间复杂度：O(1)
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (headA != null){
            headA = headA.next;
            lenA++;
        }
        while (headB != null){
            headB = headB.next;
            lenB++;
        }
        curA = headA;
        curB = headB;
        if (lenA > lenB){
            int temLen = lenA;
            lenA = lenB;
            lenB = temLen;
            ListNode temNode = curA;
            curA = curB;
            curB = temNode;
        }
        int len = lenB - lenA;
        while (len-- > 0){
            curB = curB.next;
        }
        while (curB != null){
            if (curB == curA){
                return curB;
            }
            curB = curB.next;
            curA = curA.next;
        }
        return null;
    }
}
