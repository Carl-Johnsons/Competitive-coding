public class Merge_Two_Sorted_Lists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);

        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;
        ListNode l7 = mergeTwoLists(l1, l4);
        while (l7 != null) {
            System.out.print(" -> " + l7.val);
            l7 = l7.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merge = new ListNode();
        ListNode current = merge;
        int value = Integer.MAX_VALUE;
        if (list1 != null && list2 != null && list1.val < list2.val) {
            value = list1.val;
            list1 = list1.next;
        } else if (list2 != null) {
            value = list2.val;
            list2 = list2.next;
        } else if (list1 != null) {
            value = list1.val;
            list1 = list1.next;
        } else {
            return null;
        }
        if (value != Integer.MAX_VALUE) {
            current.val = value;
        }
        
        while (list1 != null && list2 != null) {
            value = Integer.MAX_VALUE;
            if (list1 != null && list1.val < list2.val) {
                value = list1.val;
                list1 = list1.next;
            } else if (list2 != null) {
                value = list2.val;
                list2 = list2.next;
            }
            if (value != Integer.MAX_VALUE) {
                current.next = new ListNode(value);
                current = current.next;
            }
        }
        while (list1 != null) {
            value = Integer.MAX_VALUE;
            value = list1.val;
            list1 = list1.next;
            if (value != Integer.MAX_VALUE) {
                current.next = new ListNode(value);
                current = current.next;
            }
        }
        while (list2 != null) {
            value = Integer.MAX_VALUE;
            value = list2.val;
            list2 = list2.next;
            if (value != Integer.MAX_VALUE) {
                current.next = new ListNode(value);
                current = current.next;
            }
        }
        return merge;
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
