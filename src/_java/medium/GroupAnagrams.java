package _java.medium;

import java.util.*;

/**
 * @author zhaoweiguo
 * @date 2019-11-15
 */
public class GroupAnagrams {
    /**
     * problem 49
     * https://leetcode-cn.com/problems/group-anagrams/
     * <p>
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * 输出:
     *  [
     *      ["ate","eat","tea"],
     *      ["nat","tan"],
     *      ["bat"]
     *  ]
     * <p>
     * 说明：
     * 所有输入均为小写字母。
     * 不考虑答案输出的顺序。
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] charArrays = strs[i].toCharArray();
            Arrays.sort(charArrays);
            String key = new String(charArrays);

            if (!res.containsKey(key)) {
                res.put(key, new ArrayList<>());
            }
            res.get(key).add(strs[i]);
        }
        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new GroupAnagrams().groupAnagrams(strs);

        for (List<String> line : res) {
            for (String s : line) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
