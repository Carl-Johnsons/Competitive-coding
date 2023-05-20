

public class Linked_List_Cycle {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode temp = new ListNode(2);
        head.next = temp;
        temp.next = new ListNode(0);
        temp.next.next = new ListNode(-4);
        temp.next.next.next = temp;

        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode current = head;
        while (current != null && current.val != Integer.MAX_VALUE) {
            current.val = Integer.MAX_VALUE;
            current = current.next;
        }
        return current != null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
