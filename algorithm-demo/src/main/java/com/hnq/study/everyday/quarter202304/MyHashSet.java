package com.hnq.study.everyday.quarter202304;

import java.util.LinkedList;

/**
 * 设计哈希集合
 * <p>
 * 不使用任何内建的哈希表库设计一个哈希集合（HashSet）。
 * <p>
 * 实现 MyHashSet 类：
 * <p>
 * void add(key) 向哈希集合中插入值 key 。
 * bool contains(key) 返回哈希集合中是否存在这个值 key 。
 * void remove(key) 将给定值 key 从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。
 * <p>
 *
 * 示例：
 * 输入：
 * ["MyHashSet", "add", "add", "contains", "contains", "add", "contains", "remove", "contains"]
 * [[], [1], [2], [1], [3], [2], [2], [2], [2]]
 * 输出：
 * [null, null, null, true, false, null, true, null, false]
 * <p>
 * 解释：
 * MyHashSet myHashSet = new MyHashSet();
 * myHashSet.add(1);      // set = [1]
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(1); // 返回 True
 * myHashSet.contains(3); // 返回 False ，（未找到）
 * myHashSet.add(2);      // set = [1, 2]
 * myHashSet.contains(2); // 返回 True
 * myHashSet.remove(2);   // set = [1]
 * myHashSet.contains(2); // 返回 False ，（已移除）
 * <p>
 *
 * 提示：
 * 0 <= key <= 10^6
 * 最多调用 10^4 次 add、remove 和 contains
 *
 * @author henengqiang
 * @date 2023/12/4
 * @see <a href="https://leetcode.cn/problems/design-hashset/">链接</a>
 */
public class MyHashSet {

    public static final int BASE = 769;

    private final LinkedList<Integer>[] DATA;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        DATA = new LinkedList[BASE];
        for (int i = 0; i < BASE; i++) {
            DATA[i] = new LinkedList<>();
        }
    }

    public void add(int key) {
        int h = hash(key);
        for (Integer el : DATA[h]) {
            if (el == key) {
                return;
            }
        }
        DATA[h].offerLast(key);
    }

    public void remove(int key) {
        int h = hash(key);
        for (Integer el : DATA[h]) {
            if (el == key) {
                DATA[h].remove(el);
                return;
            }
        }
    }

    public boolean contains(int key) {
        int h = hash(key);
        for (Integer el : DATA[h]) {
            if (el == key) {
                return true;
            }
        }
        return false;
    }

    private static int hash(int key) {
        return key % BASE;
    }

    public static void main(String[] args) {
        // 16ms
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // 返回 True
        System.out.println(myHashSet.contains(3)); // 返回 False ，（未找到）
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // 返回 True
        myHashSet.remove(2);   // set = [1]
        System.out.println(myHashSet.contains(2)); // 返回 False ，（已移除）
    }

}
