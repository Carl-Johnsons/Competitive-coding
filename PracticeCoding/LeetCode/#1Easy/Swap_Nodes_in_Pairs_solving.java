
//https://leetcode.com/problems/swap-nodes-in-pairs/
public class Swap_Nodes_in_Pairs_solving {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);

        head.next = head1;
        head1.next = head2;
        head2.next = head3;

        ListNode current = swapPairs(head);

        while (current.next != null) {
            System.out.print(" -> " + current.val);
        }

    }

    public static ListNode swapPairs(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        int count = 0;
        while (current != null) {
            count++;
            if (count % 2 == 1) {
                prev = current;
            } else if (count % 2 == 0) {
                ListNode temp = prev.next;
                prev.next = current.next;
                current.next = temp;

            }
            current = current.next;
        }
        return head;
    }

    public static class ListNode {
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
