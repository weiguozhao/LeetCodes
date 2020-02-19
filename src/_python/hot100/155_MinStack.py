# coding:utf-8


class MinStack:
    """
    problem 155
    https://leetcode-cn.com/problems/min-stack/

    设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
    push(x) -- 将元素 x 推入栈中。
    pop() -- 删除栈顶的元素。
    top() -- 获取栈顶元素。
    getMin() -- 检索栈中的最小元素。

    示例:
    MinStack minStack = new MinStack();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    minStack.getMin();   --> 返回 -3.
    minStack.pop();
    minStack.top();      --> 返回 0.
    minStack.getMin();   --> 返回 -2.
    """

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []
        self.helper = []

    def push(self, x: int) -> None:
        self.data.append(x)
        if len(self.helper) == 0 or x <= self.helper[-1]:
            self.helper.append(x)
        else:
            self.helper.append(self.helper[-1])

    def pop(self) -> None:
        if len(self.data) > 0:
            self.helper.pop()
            return self.data.pop()
        else:
            raise Exception("No Data!")

    def top(self) -> int:
        if len(self.data) > 0:
            return self.data[-1]
        else:
            raise Exception("No Data!")

    def getMin(self) -> int:
        if len(self.helper) > 0:
            return self.helper[-1]
        else:
            raise Exception("No Data!")


# Your MinStack object will be instantiated and called as such:
# obj = MinStack()
# obj.push(x)
# obj.pop()
# param_3 = obj.top()
# param_4 = obj.getMin()


if __name__ == '__main__':
    pass
