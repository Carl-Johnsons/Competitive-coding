class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    # Recursion method
    # def reverseList(self, head: ListNode) -> ListNode:
    #     if head is None or head.next is None:
    #         return head

    #     tempNode = self.reverseList(head.next)

    #     head.next.next = head
    #     head.next = None

    #     return tempNode

    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        cur = head
        forward = None

        while cur is not None:
            forward = cur.next
            cur.next = prev

            prev = cur
            cur = forward

        return prev


sol = Solution()

input = [1, 2, 3, 4, 5]
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

cur = sol.reverseList(head)
while cur is not None:
    print(" -> ", cur.val, end="")
    cur = cur.next
