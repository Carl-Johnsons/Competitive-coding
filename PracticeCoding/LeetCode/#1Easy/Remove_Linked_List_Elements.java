
public class Remove_Linked_List_Elements {

    public static void main(String[] args) {
        Integer nodes[] = { 1, 2, 2, 1 };
        ListNode head = new ListNode(nodes[0]);
        ListNode cur = head;
        for (int i = 1; i < nodes.length; i++) {
            ListNode temp = new ListNode(nodes[i]);
            cur.next = temp;
            cur = cur.next;
        }
        head = removeElements(head, 2);
        while (head != null) {
            System.out.print(" -> " + head.val);
            head = head.next;
        }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        // Search the element first
        while (cur != null) {
            if (cur.val == val) {
                if (cur == head) {
                    head = cur.next;
                    cur = null;
                    cur = head;
                    continue;
                } else if (pre != null) {
                    pre.next = cur.next;
                    cur = cur.next;
                    continue;
                }
            }
            pre = cur;
            if (cur != null)
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