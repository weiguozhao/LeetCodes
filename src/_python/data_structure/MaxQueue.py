# coding:utf-8


class MaxQueue:
    """
    problem 面试题59 - II. 队列的最大值
    https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/

    请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
    若队列为空，pop_front 和 max_value 需要返回 -1

    示例 1：
    输入:
    ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
    [[],[1],[2],[],[],[]]
    输出: [null,null,null,2,1,2]

    示例 2：
    输入:
    ["MaxQueue","pop_front","max_value"]
    [[],[],[]]
    输出: [null,-1,-1]
     
    限制：
    1 <= push_back,pop_front,max_value的总操作数 <= 10000
    1 <= value <= 10^5
    """

    def __init__(self):

        self._que = []
        self._max = []

    def max_value(self) -> int:
        if not self._que:
            return -1
        return self._max[0]

    def push_back(self, value: int) -> None:
        self._que.append(value)
        while self._max and value > self._max[-1]:
            self._max.pop()
        self._max.append(value)

    def pop_front(self) -> int:
        if not self._que:
            return -1
        value = self._que.pop(0)
        if value == self._max[0]:
            self._max.pop(0)
        return value


# Your MaxQueue object will be instantiated and called as such:
# obj = MaxQueue()
# param_1 = obj.max_value()
# obj.push_back(value)
# param_3 = obj.pop_front()


if __name__ == '__main__':
    case1 = MaxQueue()
    case1.push_back(1)
    case1.push_back(2)
    print(case1.max_value())
    print(case1.pop_front())
    print(case1.max_value())

    case2 = MaxQueue()
    print(case2.pop_front())
    print(case2.max_value())
