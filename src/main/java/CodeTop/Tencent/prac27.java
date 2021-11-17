package CodeTop.Tencent;

/**
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换


 一共有三个步骤，按照那三个步骤去走就可以
 */
public class prac27 {

    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode pre = dump;

        while (head != null && head.next != null){
            // 先保留第三个节点
            ListNode next = head.next.next;


            pre.next = head.next;
            head.next.next = head;
            head.next = next;

            pre = head;
            head = pre.next;
        }

        return dump.next;

    }
}
