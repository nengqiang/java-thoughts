package com.hnq.study.interview;

import com.google.common.collect.Lists;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author henengqiang
 * @since 2026/6/5
 * @see <a href="https://leetcode.cn/problems/keys-and-rooms/?envType=study-plan-v2&envId=leetcode-75">钥匙和房间</a>
 */
public class CanVisitAllRooms {

    public static void main(String[] args) {
        CanVisitAllRooms c = new CanVisitAllRooms();
        System.out.println(c.canVisitAllRooms(Lists.newArrayList(Lists.newArrayList(1, 3), Lists.newArrayList(1, 4), Lists.newArrayList(2, 3, 4, 1), Lists.newArrayList(), Lists.newArrayList(4, 3, 2))));
        System.out.println(c.canVisitAllRooms(Lists.newArrayList(Lists.newArrayList(1), Lists.newArrayList(2), Lists.newArrayList(3), Lists.newArrayList())));
        System.out.println(c.canVisitAllRooms(Lists.newArrayList(Lists.newArrayList(1, 3), Lists.newArrayList(3, 0, 1), Lists.newArrayList(2), Lists.newArrayList(0))));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // 7ms
        if (rooms == null || rooms.size() == 0) {
            return false;
        }
        int[] visited = new int[rooms.size()];
        Set<Integer> visitedIndex = new HashSet<>(rooms.size());
        visited[0] = 1;
        List<Integer> keys = rooms.get(0);
        while (!keys.isEmpty()) {
            int index = keys.remove(0);
            visitedIndex.add(index);
            visited[index] = 1;
            List<Integer> newKeys = rooms.get(index);
            newKeys.removeIf(visitedIndex::contains);
            newKeys.removeAll(keys);
            keys.addAll(newKeys);
        }
        for (int flag : visited) {
            if (flag == 0) {
                return false;
            }
        }
        return true;
    }

}
