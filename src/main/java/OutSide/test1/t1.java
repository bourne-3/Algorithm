package OutSide.test1;

/**

 */
public class t1 {

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        ListNode h2= new ListNode(6);
        ListNode h3 = new ListNode(8);
        ListNode h4= new ListNode(9);

        // 初始化一个栈
        ListStack stack = new ListStack();
        stack.setHead(head);

        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());

    }


}
