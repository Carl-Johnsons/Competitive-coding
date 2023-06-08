class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    head = None
    count = 0

    def swapPairs(self, head: ListNode) -> ListNode:
        self.head = head
        self.swap(self.head, None, None)
        return self.head

    def swap(self, cur: ListNode, pre: ListNode, prevOfPre: ListNode) -> None:
        self.count += 1
        if self.count == 2:
            pre.next = cur.next
            cur.next = pre
            if pre == self.head:
                self.head = cur
            if pre.next is None:
                return
            prevOfPre = pre
            cur = pre.next
            self.count += 1

        if self.count % 2 == 0:
            pre.next = cur.next
            cur.next = pre
            prevOfPre.next = cur
            if pre.next is None:
                return
            cur = pre.next
            prevOfPre = pre
            self.count += 1

        if cur is not None and cur.next is not None:
            self.swap(cur.next, cur, prevOfPre)


sol = Solution()
testcase = [1, 2, 3, 4, 5]
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

cur = sol.swapPairs(head)
while cur is not None:
    print(" -> ", cur.val, end="")
    cur = cur.next

print()
