class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    count = 0
    k = 0
    head = None
    lastNode = None

    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        self.k = k
        self.head = head
        self.rotate(None, head)
        return self.head

    def rotate(self, pre: ListNode, cur: ListNode) -> None:
        if cur is not None:
            self.count += 1
            if cur.next is None:
                self.k = self.k % self.count
                self.lastNode = cur

            self.rotate(cur, cur.next)
            self.k -= 1

            if self.k == 0:
                pre.next = None
                self.lastNode.next = self.head
                self.head = cur


testcase = [1, 2, 3, 4, 5]
k = 104


head = ListNode(testcase[0])
cur = head
for i in range(1, len(testcase)):
    cur.next = ListNode(testcase[i])
    cur = cur.next

cur = head
while cur is not None:
    print(" -> ", cur.val, end="")
    cur = cur.next
print()
sol = Solution()
cur = sol.rotateRight(head, k)

while cur is not None:
    print(" -> ", cur.val, end="")
    cur = cur.next
print()
