# coding:utf-8


class Solution:
    """
    请你编写一个程序来计算两个日期之间隔了多少天。
    日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。

    示例 1：
    输入：date1 = "2019-06-29", date2 = "2019-06-30"
    输出：1

    示例 2：
    输入：date1 = "2020-01-15", date2 = "2019-12-31"
    输出：15

    提示：
    给定的日期是 1971 年到 2100 年之间的有效日期。
    """

    def daysBetweenDates(self, date1: str, date2: str) -> int:
        month_day = {1: 31, 2: 28, 3: 31, 4: 30, 5: 31, 6: 30, 7: 31, 8: 31, 9: 30, 10: 31, 11: 30, 12: 31}
        if date1 > date2:
            return self.daysBetweenDates(date2, date1)

        date_part1 = [int(x) for x in date1.split("-")]
        date_part2 = [int(x) for x in date2.split("-")]
        ans = 0
        for year in range(date_part1[0], date_part2[0]):
            if self._is_leap_year_(year):
                ans += 366
            else:
                ans += 365

        for month in range(1, date_part1[1]):
            if self._is_leap_year_(date_part1[0]) and month == 2:
                ans -= 1
            ans -= month_day[month]

        ans -= date_part1[2]

        for month in range(1, date_part2[1]):
            if self._is_leap_year_(date_part2[0]) and month == 2:
                ans += 1
            ans += month_day[month]

        ans += date_part2[2]
        return ans

    def _is_leap_year_(self, year) -> bool:
        if year % 100 == 0:
            if year % 400 == 0:
                return True
            else:
                return False
        elif year % 4 == 0:
            return True
        else:
            return False


if __name__ == '__main__':
    date1 = "2020-01-15"
    date2 = "2019-12-31"
    res = Solution().daysBetweenDates(date1, date2)
    print(res)
