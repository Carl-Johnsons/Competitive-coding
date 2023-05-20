public class Remove_Duplicates_from_Sorted_List {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(2);
        ListNode head4 = new ListNode(3);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;
        head3.next = head4;

        ListNode cur = deleteDuplicates(head);
        while (cur != null) {
            System.out.print(" -> " + cur.val);
            cur = cur.next;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        ListNode temp;
        int currentValue = 0;
        currentValue = cur.val;
        while (cur != null && cur.next != null) {
            if (currentValue != cur.val) {
                currentValue = cur.val;
            }

            if (currentValue == cur.next.val) {
                temp = cur.next;
                cur.next = temp.next;
                temp.next = null;
                temp = null;
            }
            if (cur.next != null && cur.next.val != currentValue)
                cur = cur.next;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
