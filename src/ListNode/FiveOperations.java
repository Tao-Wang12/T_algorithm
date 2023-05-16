package ListNode;

/**
 * 题目：你可以选择使用单链表或者双链表，设计并实现自己的链表。
 * <p>
 * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
 * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
 * <p>
 * 实现 FiveOperations 类：
 * FiveOperations() 初始化 FiveOperations 对象。
 * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
 * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
 * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
 * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
 * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
 */
public class FiveOperations {
    int size; // 链表大小
    ListNode head; // 虚拟头节点
    // 实例化 FiveOperations 类
    public FiveOperations(){
        size = 0;
        head = new ListNode(0);
    }
    // 获取链表中下标为 index 的节点的值
    public int get(int index){
        if (index < 0 || index >= size)
            return -1;
        ListNode cur = head.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        return cur.val;
    }
    // 将一个值为 val 的节点插入到链表中第一个元素之前
    public void addAtHead(int val){
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
//        addAtIndex(0, val);
    }
    // 将一个值为 val 的节点追加到链表中作为链表的最后一个元素
    public void addAtTail(int val){
        ListNode cur = head;
        for (int i = 0; i < size; i++){
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        cur.next = newNode;
        size++;
//        addAtIndex(size, val);
    }
    // 将一个值为 val 的节点插入到链表中下标为 index 的节点之前
    public void addAtIndex(int index, int val){
        // 若 index 大于链表长度，则无需插入
        if (index > size)
            return;
        // 若 index<0 ，则与插入头节点相同处理
        if (index < 0){
            index = 0;
        }
        // 一般情况
        size++;
        ListNode pre = head; // 拆入位置的前一节点
        for (int i = 0; i < index; i++){
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
    }
    // 如果下标有效，则删除链表中下标为 index 的节点
    public void deleteAtIndex(int index){
        // 判断下表不存在的情况
        if (index < 0 || index >= size)
            return;
        size--;
        // 删除头节点的情况
        if (index == 0) {
            head = head.next;
            return;
        }
        // 其他情况
        ListNode pre = head;
        for (int i = 0; i < index; i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
