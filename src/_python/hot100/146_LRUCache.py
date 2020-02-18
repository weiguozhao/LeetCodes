# coding:utf-8


class ListNode:
    def __init__(self, key=None, value=None):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class LRUCache:
    """
    problem 146
    https://leetcode-cn.com/problems/lru-cache/

    运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
    获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
    写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。

    进阶:
    你是否可以在 O(1) 时间复杂度内完成这两种操作？

    示例:
    LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // 返回  1
    cache.put(3, 3);    // 该操作会使得密钥 2 作废
    cache.get(2);       // 返回 -1 (未找到)
    cache.put(4, 4);    // 该操作会使得密钥 1 作废
    cache.get(1);       // 返回 -1 (未找到)
    cache.get(3);       // 返回  3
    cache.get(4);       // 返回  4
    """

    def __init__(self, capacity: int):
        """hash表 + 双向链表"""
        self.capacity = capacity
        # key -> node address
        self.hash_map = {}
        self.head = ListNode()
        self.tail = ListNode()
        # 初始化 head <-> tail
        self.head.next = self.tail
        self.tail.prev = self.head

    def _move_node_to_tail_(self, key: int):
        #
        node = self.hash_map[key]
        node.prev.next = node.next
        node.next.prev = node.prev

        node.prev = self.tail.prev
        node.next = self.tail
        self.tail.prev.next = node
        self.tail.prev = node

    def get(self, key: int) -> int:
        if key in self.hash_map:
            # 如果已经在链表中了就把它移到末尾(变成最新访问的)
            self._move_node_to_tail_(key)
        res = self.hash_map.get(key, -1)
        if res == -1:
            return res
        else:
            return res.value

    def put(self, key: int, value: int) -> None:
        if key in self.hash_map:
            # key已经在hash表中不需要在链表中加入新的节点
            # 需要更新字典该值对应节点的 value
            self.hash_map[key] = value
            # 之后将该节点移到末尾, 表示最近访问
            self._move_node_to_tail_(key)

        else:
            if len(self.hash_map) == self.capacity:
                # 去掉hash表对应项
                self.hash_map.pop(self.head.next.key)
                # 去掉最久没有被访问过的节点，即头节点之后的节点
                self.head.next = self.head.next.next
                self.head.next.prev = self.head

            # 不在hash表就插入到尾节点前
            new = ListNode(key, value)
            self.hash_map[key] = new
            new.prev = self.tail.prev
            new.next = self.tail
            self.tail.prev.next = new
            self.tail.prev = new


# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)

"""cpp version
class LRUCache {

private:
    int capacity_;
    list<pair<int, int>> ls_;
    unordered_map<int, list<pair<int, int>>::iterator> hash_;

public:
    LRUCache(int capacity) : capacity_(capacity) {}

    int get(int key) {
        if (hash_.find(key) == hash_.end())
            return -1;
        else {
            int value = hash_[key]->second;
            ls_.erase(hash_[key]);
            ls_.push_front(make_pair(key, value));
            hash_[key] = ls_.begin();
            return value;
        }
    }

    void put(int key, int value) {
        if (hash_.find(key) != hash_.end())
            ls_.erase(hash_[key]);
        else if (ls_.size() >= capacity_) {
            hash_.erase(ls_.back().first);
            ls_.pop_back();
        }
        ls_.push_front(make_pair(key, value));
        hash_[key] = ls_.begin();
    }
};
"""


if __name__ == '__main__':
    cache = LRUCache(capacity=2)
    cache.put(1, 1)
    cache.put(2, 2)
    print(cache.get(1))
    cache.put(3, 3)
    print(cache.get(2))
    cache.put(4, 4)
    print(cache.get(1))
    print(cache.get(3))
    print(cache.get(4))
