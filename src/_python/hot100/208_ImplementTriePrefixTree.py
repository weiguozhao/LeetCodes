# coding:utf-8


class TrieNode:
    def __init__(self, is_end=False):
        self.__letters__ = "abcdefghijklmnopqrstuvwxyz"
        self.childers = dict([(x, None) for x in self.__letters__])
        self.is_end = is_end


class Trie:
    """
    problem 208
    https://leetcode-cn.com/problems/implement-trie-prefix-tree/

    实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。

    示例:
    Trie trie = new Trie();
    trie.insert("apple");
    trie.search("apple");   // 返回 true
    trie.search("app");     // 返回 false
    trie.startsWith("app"); // 返回 true
    trie.insert("app");
    trie.search("app");     // 返回 true

    说明:
    你可以假设所有的输入都是由小写字母 a-z 构成的。
    保证所有输入均为非空字符串。
    """

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        point = self.root
        for i, ch in enumerate(word):
            if point.childers[ch] is None:
                point.childers[ch] = TrieNode()

            point = point.childers[ch]
        point.is_end = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        point = self.root
        for ch in word:
            if point.childers[ch] is None:
                return False
            point = point.childers[ch]
        return point.is_end

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        point = self.root
        for ch in prefix:
            if point.childers[ch] is None:
                return False
            point = point.childers[ch]
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)


if __name__ == '__main__':
    trie = Trie()
    trie.insert("apple")
    print(trie.search("apple"))  # 返回true
    print(trie.search("app"))  # 返回false
    print(trie.startsWith("app"))  # 返回true
    trie.insert("app")
    print(trie.search("app"))  # 返回true
