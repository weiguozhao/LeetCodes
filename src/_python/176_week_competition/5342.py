# coding:utf-8

from typing import List


class Solution:
    """
    给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
    你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
    请你返回你可以参加的 最大 会议数目。
    https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2020/02/16/e1.png

    示例 1：
    输入：events = [[1,2],[2,3],[3,4]]
    输出：3
    解释：你可以参加所有的三个会议。
    安排会议的一种方案如上图。
    第 1 天参加第一个会议。
    第 2 天参加第二个会议。
    第 3 天参加第三个会议。

    示例 2：
    输入：events= [[1,2],[2,3],[3,4],[1,2]]
    输出：4

    示例 3：
    输入：events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
    输出：4

    示例 4：
    输入：events = [[1,100000]]
    输出：1

    示例 5：
    输入：events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
    输出：7

    提示：
    1 <= events.length <= 10^5
    events[i].length == 2
    1 <= events[i][0] <= events[i][1] <= 10^5
    """

    def maxEvents(self, events: List[List[int]]) -> int:
        events = sorted(events, key=lambda x: (x[1], x[0]))
        # is_used表示有哪些天已经用来参加会议了
        is_used, ans = set(), 0

        for i in range(len(events)):
            # 从会议开始到会议结束
            for j in range(events[i][0], events[i][1] + 1):
                if j in is_used:
                    continue
                else:
                    is_used.add(j)
                    ans += 1
                    break

        return ans


if __name__ == '__main__':
    events = [[1, 5], [1, 5], [1, 5], [2, 3], [2, 3]]
    print(Solution().maxEvents(events))
