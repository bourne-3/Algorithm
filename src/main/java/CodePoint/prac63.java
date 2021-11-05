package CodePoint;

/**
 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
 求出这个圆圈里剩下的最后一个数字。

 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，
 因此最后剩下的数字是3。

 */
public class prac63 {

    public static void main(String[] args) {
        prac63 t = new prac63();
        t.lastRemaining(5,3);  // 3
//        t.lastRemaining(10,17);  // 2
    }

    public int lastRemaining(int n, int m) {
        // 构建链表
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = 0; i < n; i++){
            ListNode tmpNode = new ListNode(i);
            cur.next = tmpNode;
            cur = tmpNode;
        }
        cur.next = head.next; // 单向循环链表



        ListNode pre = head;
        cur = head;
        while (cur.next != null){
            for (int i = 0; i < m; i++){
                pre = cur;
                cur = cur.next;
            }
            pre.next = cur.next;
            cur.next = null;  // 这里要断开那个节点。
            cur = pre;
        }
        System.out.println(cur.val);

        return -1;
    }
}
