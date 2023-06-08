class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def reverseBetween(self, head: ListNode, left: int, right: int) -> ListNode:
        count = 0
        cur = head
        prev = None
        nxt = None

        while cur is not None:
            count += 1
            if count >= left and count <= right:
                nxt = cur.next
                cur.next = prev

                prev = cur
                cur = nxt
                head = prev
            else:
                cur = cur.next
        return head


input = [1, 2, 3, 4, 5]
left = 1
right = 5

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
