package CodeTop.Tencent;


/**

 */
public class ListStack {
    ListNode head;
    int size;

    public int peek(){
        return head.val;
    }

    public void push(int val){
        ListNode node = new ListNode(val);
        // 头插法
        node.next = head;
        head = node;
    }

    public int pop(){
        // 返回头节点的内容
        ListNode tmp = head;
        head = head.next;
        return tmp.val;
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
