
public class Add_Two_Numbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);

        ListNode l8 = new ListNode(9);
        ListNode l9 = new ListNode(9);
        ListNode l10 = new ListNode(9);
        ListNode l11 = new ListNode(9);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;

        l8.next = l9;
        l9.next = l10;
        l10.next = l11;
        ListNode head = addTwoNumbers(l1, l8);
        while (head != null) {
            System.out.print(" -> " + head.val);
            head = head.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;

        int remaining = 0;
        int count = 0;

        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val;

            if (count < 1)
                tail.val = value % 10;
            else {
                if (remaining == 1) {
                    value = value + remaining;
                    remaining = (value >= 10 ? 1 : 0);
                    tail.next = new ListNode(remaining);
                }
                if (tail.next == null) {
                    tail.next = new ListNode(value % 10);
                } else {
                    tail.next.val = value % 10;
                }
                tail = tail.next;
                if (remaining == 1) {
                    tail.next = new ListNode(remaining);
                }
            }
            l1 = l1.next;
            l2 = l2.next;
            remaining = (value >= 10 ? 1 : 0);
            count++;
        }
        // if l1 still has elements
        while (l1 != null) {
            int value = l1.val;

            if (count < 1)
                tail.val = value % 10;
            else {
                if (remaining == 1) {
                    value = value + remaining;
                    remaining = (value >= 10 ? 1 : 0);
                    tail.next = new ListNode(remaining);
                }
                if (tail.next == null) {
                    tail.next = new ListNode(value % 10);
                } else {
                    tail.next.val = value % 10;
                }
                tail = tail.next;
                if (remaining == 1) {
                    tail.next = new ListNode(remaining);
                }
            }
            l1 = l1.next;
            remaining = (value >= 10 ? 1 : 0);
            count++;
        }
        // if l2 still has elements
        while (l2 != null) {
            int value = l2.val;

            if (count < 1)
                tail.val = value % 10;
            else {
                if (remaining == 1) {
                    value = value + remaining;
                    remaining = (value >= 10 ? 1 : 0);
                    tail.next = new ListNode(remaining);
                }
                if (tail.next == null) {
                    tail.next = new ListNode(value % 10);
                } else {
                    tail.next.val = value % 10;
                }
                tail = tail.next;
                if (remaining == 1) {
                    tail.next = new ListNode(remaining);
                }
            }
            l2 = l2.next;
            remaining = (value >= 10 ? 1 : 0);
            count++;
        }
        // handle if still have the remaining
        if (remaining == 1) {
            tail.next = new ListNode(remaining);
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
