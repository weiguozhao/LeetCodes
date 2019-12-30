package _java.hard;

import _java.utils.ListNode;

import java.util.*;

/**
 * @author zhaoweiguo
 * @date 2019-12-29
 */
public class SubstringwithConcatenationofAllWords {
    /**
     * problem 30
     * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/
     * <p>
     * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
     * <p>
     * 示例 1：
     * 输入：
     * s = "barfoothefoobarman",
     * words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
     * 输出的顺序不重要, [9,0] 也是有效答案。
     * <p>
     * 示例 2：
     * 输入：
     * s  = "wordgoodgoodgoodbestword",
     * words = ["word","good","best","word"]
     * 输出：[]
     */

    /**
     * 简单匹配：每次从s中取 words.length() * words[0].length() 个字符，然后和words数组进行匹配
     * time: O(Nk)
     * space: O(k)
     *
     * 执行用时 : 190 ms, 在所有 java 提交中击败了 27.89% 的用户
     * 内存消耗 : 41.5 MB , 在所有 java 提交中击败了 91.19% 的用户
     * */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int length = words.length;

        if (length < 1) {
            return res;
        }

        int count;
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            count = wordsMap.getOrDefault(word, 0);
            wordsMap.put(word, count + 1);
        }

        String str;
        int wordLength = words[0].length();
        for (int i = 0; i <= s.length() - length * wordLength; i++) {

            Map<String, Integer> partOfStr = new HashMap<>();
            for (int j = i; j < i + length * wordLength; j += wordLength) {
                str = s.substring(j, j + wordLength);
                count = partOfStr.getOrDefault(str, 0);
                partOfStr.put(str, count + 1);
            }

            boolean isSame = true;
            for(Map.Entry<String, Integer> entry: wordsMap.entrySet()) {
                count = partOfStr.getOrDefault(entry.getKey(), 0);
                if (count != entry.getValue()) {
                    isSame = false;
                    break;
                }
            }

            if (isSame) {
                res.add(i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
//         String s = "barfoothefoobarman";
//         String[] words = {"foo","bar"};

//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word","good","best","word"};

//        String s = "wordgoodgoodgoodbestword";
//        String[] words = {"word","good","best","good"};

        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo","barr","wing","ding","wing"};
        List<Integer> res = new SubstringwithConcatenationofAllWords().findSubstring(s, words);
        for (Integer x: res) {
            System.out.print(x + " ");
        }
    }
}
