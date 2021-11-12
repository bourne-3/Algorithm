package OutSide.test1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**

 */
public class t02 {

    public static void main(String[] args) {

    }

    public void merge(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        merge(nums, l, mid);
        merge(nums, mid + 1, r);
        merSort(nums, l, r, mid);

    }

    private void merSort(int[] nums, int l, int r, int mid) {
        int t1 = l, t2 = mid + 1;
        int[] tmp = new int[r - l + 1];
        int c = 0;
        while (t1 <= mid && t2 <= r){
            if (nums[t1] < nums[t2]) tmp[c++] = nums[t1++];
            else tmp[c++] = nums[t2++];
        }

        // 收尾
        while (t1 <= mid) tmp[c++] = nums[t1++];
        while (t2 <= r) tmp[c++] = nums[t2++];

        // 最终的结果
        for (int i = 0; i < tmp.length; i++) {
            nums[i + l] = tmp[i];
        }
    }


    public ListNode sortList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        Collections.sort(list);
        ListNode dump = new ListNode(-1);
        ListNode cur = dump;
        for (int i : list) {
            ListNode node = new ListNode(i);
            cur.next = node;
            cur = cur.next;
        }
        return dump.next;

    }
}
