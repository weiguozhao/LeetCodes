# coding:utf-8

import heapq


class MaxHeap(heapq):
    """
    heapq内部实现的是最小堆
    要用最大堆的话：
        1. push进的元素取相反数
        2. pop出的元素取相反数
    """

    def __init__(self, heap):
        """
        堆是基于list实现的
        :param heap: 数组
        """
        self.heap = heap

    def push(self, item):
        """
        将 item 的值加入 heap 中，保持堆的不变性。
        """
        heapq.heappush(self.heap, -item)

    def pop(self):
        """
        弹出并返回 heap 的最小的元素，保持堆的不变性。
        如果堆为空，抛出 IndexError 。
        """
        return -heapq.heappop(self.heap)

    def pushAndPop(self, item):
        """
        将 item 放入堆中，然后弹出并返回 heap 的最小元素。
        该组合操作比先调用  heappush() 再调用 heappop() 运行起来更有效率。
        """
        return -heapq.heappushpop(self.heap, item)

    def popAndPush(self, item):
        """
        弹出并返回 heap 中最小的一项，同时推入新的 item。
        """
        return -heapq.heapreplace(self.heap, item)

    def _heapify_(self):
        """
        将list x 转换成堆，原地，线性时间内。
        """
        heapq.heapify(self.heap)
