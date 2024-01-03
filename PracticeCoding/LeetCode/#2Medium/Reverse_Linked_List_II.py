class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseBetween(self, head: ListNode, left: int, right: int) -> ListNode:
        count = 0
        cur = head
        prev = None
        prev_next = cur
        nxt = cur.next

        while cur is not None:
            count += 1
            nxt = cur.next
            if count >= left and count < right:
                if left == 1: # if the head need to reverse
                    cur.next = nxt.next
                    nxt.next = head

                    head = nxt
                else:
                    prev.next = cur.next
                    cur.next = nxt.next
                    nxt.next = prev_next

                    prev_next = prev.next
                    nxt = cur.next
            else:
                prev = cur
                prev_next = prev.next
                cur = cur.next
        return head


input = [1, 2, 3, 4, 5]
left = 2
right = 3

head = ListNode(input[0])
cur = head
for i in range(1, len(input)):
    cur.next = ListNode(input[i])
    cur = cur.next
cur = head
while cur is not None:
    print(" -> ", cur.val, end="")
    cur = cur.next
print()

sol = Solution()
cur = sol.reverseBetween(head, left, right)
while cur is not None:
    print(" -> ", cur.val, end="")
    cur = cur.next
